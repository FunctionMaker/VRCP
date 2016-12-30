package com.carfi.vrcp2.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.Organization;
import com.carfi.vrcp2.pojo.PageDomain;
import com.carfi.vrcp2.pojo.RespObj;
import com.carfi.vrcp2.pojo.UFBridge;
import com.carfi.vrcp2.pojo.User;
import com.carfi.vrcp2.query.OrganizationQuery;
import com.carfi.vrcp2.service.IOrgUserService;
import com.carfi.vrcp2.service.IOrganizationService;

@Controller
@RequestMapping("/carfi/organization")
public class OrganizationController {
	
	@Autowired
	private IOrganizationService orgService;
	
	@Autowired
	private IOrgUserService orgUserService;
	
	@RequestMapping("/index")
	public String index(){
		return "/carfi/organization";
	}
	
	@RequestMapping("/input")
	public String input(Long id,HttpServletRequest request){
		if(id!=null){
			Organization org = orgService.queryOne(id);
			request.setAttribute("org", org);
			request.setAttribute("orgUser", orgUserService.queryOneByOrgId(org.getId()));
			return "/carfi/editOrgnization";
		}else{
			return "/carfi/editOrgnization";
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public RespObj edit(Organization org,OrgUser orgUser,UFBridge ufBridge,HttpSession session){
		org.setId(ufBridge.getOrgId());
		org.setTerminalNum(ufBridge.getOrgTerminalNum());
		org.setLevel(1);
		orgUser.setId(ufBridge.getOrgUserId());
		User user = (User)session.getAttribute(Constant.USER_IN_SESSION);
		orgUser.setCreateByCarfi(user.getUsername());
		orgUser.setTerminalNum(ufBridge.getOrgUserTerminalNum());
		RespObj respObj = new RespObj();
		try{
			OrgRole orgRole = new OrgRole();
			orgRole.setId(1L);
			if(org.getId() == null){
				orgService.saveOrgAndUser(org, orgUser);
			}else{
				orgUser.setOrgRole(orgRole);
				orgService.updOrgAndUser(org, orgUser);
			}
			respObj.setSuccess(true);
			respObj.setMsg("成功");
		}catch(Exception e){
			e.printStackTrace();
			respObj.setSuccess(false);
			respObj.setMsg("失败");
		}
		return respObj;
		
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public RespObj del(Long id){
		RespObj respObj = new RespObj();
		try{
			orgService.setNotEffective(id);
			respObj.setSuccess(true);
			respObj.setMsg("成功");
		}catch(Exception e){
			System.err.println(e);
			respObj.setSuccess(false);
			respObj.setMsg("失败");
		}
		return respObj;
	}
	
	@ResponseBody
	@RequestMapping("/getOrgDatas")
	public PageDomain<Organization> getOrgDatas(Integer draw,Integer start,Integer length,Long parentId,HttpServletRequest request) throws UnsupportedEncodingException{
		OrganizationQuery organizationQuery = new OrganizationQuery();
		organizationQuery.setParentId(parentId);
		String searchParam = request.getParameter("search[value]");
		if(searchParam != null){
			String search = new String(searchParam.getBytes("ISO-8859-1"),"UTF-8");
			organizationQuery.setName(search);
		}
		//解决搜索关键字中文乱码
		PageDomain<Organization> pageDomain = new PageDomain<Organization>();
		pageDomain.setDraw(draw);
		pageDomain.setRecordsTotal(orgService.queryTotalCount());
		pageDomain.setRecordsFiltered(orgService.queryTotalCountByQuery(organizationQuery));
		pageDomain.setData(orgService.queryAllByQuery(organizationQuery));
		return pageDomain;
	}
	
	@ResponseBody
	@RequestMapping("/checkOrgFullName")
	public Map<String,Object> checkOrgFullName(String fullName) throws UnsupportedEncodingException{
		Map<String,Object> result = new HashMap<String, Object>();
		Organization organization = orgService.queryByOrganizationName(new String(fullName.getBytes("ISO-8859-1"),"UTF-8").trim());
		if(organization != null){
			result.put("valid", false);
		}else{
			result.put("valid", true);
		}
		return result;
	}
}
