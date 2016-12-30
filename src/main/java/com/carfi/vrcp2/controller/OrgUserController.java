package com.carfi.vrcp2.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.PageDomain;
import com.carfi.vrcp2.pojo.RespObj;
import com.carfi.vrcp2.query.OrgUserQuery;
import com.carfi.vrcp2.service.IOrgRoleService;
import com.carfi.vrcp2.service.IOrgUserService;
import com.carfi.vrcp2.util.MD5Util;

/** 
* 
* @Description:与组织用户相关的控制器
* @author gjw 
* 
*/
@Controller
@RequestMapping("/org/user")
public class OrgUserController {
	@Autowired
	private IOrgRoleService orgRoleService;
	@Autowired
	private IOrgUserService orgUserService;
	/**  
	*  
	* @Description: 点击菜单中的用户管理改变右侧显示
	* @return String
	*  
	*/  
	@RequestMapping("/userList")
	public String orgUserList(){
		return "/org/userList";
	}
	/**  
	*  
	* @Description: 填充用户表格数据
	* @param draw
	* @param start
	* @param length
	* @param request
	* @param session
	* @return PageDomain<OrgUser> 
	*/  
	@ResponseBody
	@RequestMapping("/getUserData")
	public PageDomain<OrgUser> getUserData(Integer draw,Integer start,Integer length,HttpServletRequest request,HttpSession session){
		long id = ((OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION)).getOrganization().getId();
		OrgUserQuery orgUserQuery = new OrgUserQuery();
		orgUserQuery.setOrgId(id);
		orgUserQuery.setBeginIndex(start);
		orgUserQuery.setPageNum(length);
		String searchParam = request.getParameter("search[value]");
		if(searchParam != null&&!searchParam.equals("")){
			orgUserQuery.setName(searchParam);
		}
		PageDomain<OrgUser> orgUsers = new PageDomain<OrgUser>();
		orgUsers.setDraw(draw);
		orgUsers.setRecordsTotal(orgUserService.queryCountByOrgId(id));
		orgUsers.setRecordsFiltered(orgUserService.queryCountByQuery(orgUserQuery));
		orgUsers.setData(orgUserService.queryDataByQuery(orgUserQuery));
		return orgUsers;
	}
	/**  
	*  
	* @Description: 跳转到添加用户页面
	* @param session
	* @param modelMap
	* @return String
	*  
	*/  
	@RequestMapping("/input")
	public String addUserPage(HttpSession session, ModelMap modelMap){
		long orgId = ((OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION)).getOrganization().getId();
		List<OrgRole> orgRoles = orgRoleService.queryAllByOrgId(orgId);
		modelMap.addAttribute("roles", orgRoles);
		return "/org/addorguser";
	}
	/**  
	*  
	* @Description: 用户添加方法
	* @param user
	* @param session
	* @return String
	*  
	*/  
	@RequestMapping("/add")
	public String addUser(OrgUser user,HttpSession session){
		OrgUser orgUser = (OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION);
		user.setPassword(MD5Util.string2MD5(user.getPassword()));
		user.setCreateBy(orgUser);
		user.setTerminalNum(0l);
		user.setLastLoginTime(new Date());
		user.setOrganization(orgUser.getOrganization());
		orgUserService.save(user);
		return "redirect:/org/index/main";
	}
	/**  
	*  
	* @Description: 添加用户时检查账号是否存在
	* @param accountName
	* @return RespObj
	*  
	*/  
	@RequestMapping("/checkUserName")
	@ResponseBody
	public Map<String,Object> checkUserName(String accountName){
		Map<String, Object> map = new HashMap<String,Object>();
		if(orgUserService.queryOrgUserByAccount(accountName)!=null){
			map.put("valid", false);
			return map;
		}else {
			map.put("valid", true);
		}
		return map;
	}
	/**  
	*  
	* @Description: 跳转到修改用户页面
	* @param id
	* @param modelMap
	* @return String
	*  
	*/  
	@RequestMapping("/updatePage")
	public String updateUserPage(Long id,ModelMap modelMap){
		OrgUser user = orgUserService.queryOne(id);
		List<OrgRole> orgRoles = orgRoleService.queryAllByOrgId(user.getOrganization().getId());
		modelMap.addAttribute("roles", orgRoles);
		modelMap.addAttribute("user", user);
		return "/org/updateorguser";
	}
	/**  
	*  
	* @Description: 修改用户信息的方法
	* @param user
	* @return String
	*  
	*/  
	@RequestMapping("/update")
	public String updateUser(OrgUser user){
		OrgUser orgUser = orgUserService.queryOrgUserByAccount(user.getAccountName());
		orgUser.setManager(user.getManager());
		orgUser.setPhone(user.getPhone());
		orgUser.setOrgRole(user.getOrgRole());
		orgUserService.update(orgUser);
		return "redirect:/org/index/main";
	}
	/**  
	*  
	* @Description: 删除用户的方法
	* @param id
	* @return RespObj
	*  
	*/  
	@RequestMapping("/del")
	@ResponseBody
	public RespObj delUser(Long id){
		RespObj respObj = new RespObj();
		respObj.setSuccess(false);
		System.out.println(id);
		orgUserService.delete(id);
		if(orgUserService.queryOne(id)==null){
			respObj.setSuccess(true);
		}else {
			respObj.setMsg("其下有终端设备，删除失败！");
		}
		return respObj;
	}
}
