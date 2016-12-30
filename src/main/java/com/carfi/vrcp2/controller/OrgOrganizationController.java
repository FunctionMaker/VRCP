package com.carfi.vrcp2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.Organization;
import com.carfi.vrcp2.pojo.PageDomain;
import com.carfi.vrcp2.pojo.RespObj;
import com.carfi.vrcp2.query.OrganizationQuery;
import com.carfi.vrcp2.service.IOrgUserService;
import com.carfi.vrcp2.service.IOrganizationService;
import com.carfi.vrcp2.util.MD5Util;



/** 
* 
* @Description:组织控制器类
* @author gjw 
* 
*/
@Controller
@RequestMapping("/org/organization")
public class OrgOrganizationController {
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IOrgUserService orgUserService;
	/**  
	*  
	* @Description: 点击左侧组织管理菜单的请求跳转
	* @return String
	*  
	*/  
	@RequestMapping("/orgList")
	public String orgListPage(HttpSession session,ModelMap modelMap){
		OrgUser user = (OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION);
		Organization organization = organizationService.queryOne(user.getOrganization().getId());
		modelMap.addAttribute("organization", organization);
		return "/org/organizationList";
	}
	/**  
	*  
	* @Description: 获取组织数据
	* @param draw
	* @param start
	* @param length
	* @param request
	* @param session
	* @return PageDomain<Organization>
	*  
	*/  
	@RequestMapping("/getOrgDatas")
	@ResponseBody
	public PageDomain<Organization> getOrgData(Integer draw,Integer start,Integer length,HttpServletRequest request,HttpSession session){
		Long orgId = ((OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION)).getOrganization().getId();
		OrganizationQuery organizationQuery = new OrganizationQuery();
		organizationQuery.setPageNum(Integer.MAX_VALUE);
		organizationQuery.setParentId(orgId);
		PageDomain<Organization> organizations = new PageDomain<Organization>();
		organizations.setDraw(draw);
		organizations.setRecordsTotal(organizationService.queryTotalCountByQuery(organizationQuery));
		String searchParam = request.getParameter("search[value]");
		if(searchParam!=null&&!searchParam.equals("")){
			organizationQuery.setName(searchParam);
		}
		organizations.setRecordsFiltered(organizationService.queryTotalCountByQuery(organizationQuery));
		organizations.setData(organizationService.queryAllByQuery(organizationQuery));
		return organizations;
	}
	/**  
	*  
	* @Description: 跳转到增加组织的页面
	* @return String
	*  
	*/  
	@RequestMapping("/input")
	public String addOrgnizationPage(){
		return "/org/addOrgnization";
	}
	/**  
	*  
	* @Description: 增加组织的方法
	* @param organization
	* @param user
	* @param session
	* @param request
	* @return String
	*  
	*/  
	@RequestMapping("/add")
	public String addOrgnization(Organization organization,OrgUser user,HttpSession session,HttpServletRequest request){
		OrgUser orgUser = (OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION);
		user.setCreateBy(orgUser);
		user.setPassword(MD5Util.string2MD5(user.getPassword()));
		OrgRole orgRole = new OrgRole();
		orgRole.setId(1l);
		user.setOrgRole(orgRole);
		String address = request.getParameter("s_province");
		address += "_" + request.getParameter("s_city");
		address += "_" + request.getParameter("s_county");
		address += "_" + request.getParameter("s_detail_addr");
		organization.setAddress(address);
		organization.setParent(orgUser.getOrganization());
		organizationService.saveOrgAndUser(organization, user);
		return "redirect:/org/index/main";
	}
	/**  
	*  
	* @Description: 检查组织全名是否存在的方法
	* @param fullName
	* @return Map<String,Object>
	*  
	*/  
	@RequestMapping("/checkFullName")
	@ResponseBody
	public Map<String,Object> checkUserName(String fullName){
		Map<String, Object> map = new HashMap<String,Object>();
		if(organizationService.queryByOrganizationName(fullName)!=null){
			map.put("valid", false);
			return map;
		}else {
			map.put("valid", true);
		}
		return map;
	}
	/**  
	*  
	* @Description: 跳转到组织修改页面
	* @param id
	* @param modelMap
	* @return
	*  
	*/  
	@RequestMapping("/updPage")
	public String updOrgnizationPage(Long id,ModelMap modelMap){
		Organization organization = organizationService.queryOne(id);
		OrgUser orgUser = orgUserService.queryOneByOrgId(id);
		modelMap.addAttribute("org", organization);
		modelMap.addAttribute("orgUser", orgUser);
		return "/org/updOrgnization";
	}
	@RequestMapping(value="/upd",method=RequestMethod.POST)
	public String updOrgnization(Organization organization,OrgUser orgUser){
		System.out.println("org:"+JSON.toJSONString(organization));
		System.out.println("user:"+JSON.toJSONString(orgUser));
		//organizationService.updOrgAndUser(organization, orgUser);
		return "";
	}
	@RequestMapping("/del")
	@ResponseBody
	public RespObj delOrgnization(Long id){
		RespObj respObj = new RespObj();
		respObj.setSuccess(false);
		Organization organization = organizationService.queryOne(id);
		if(!organization.getHasSonNode()&&organization.getTerminalNum()==0){
			//执行删除操作
			organizationService.updOrgnization(id);
			respObj.setSuccess(true);
		}else {
			respObj.setMsg("此组织有子组织或设备不能删除");
		}
		return respObj;
	}
}
