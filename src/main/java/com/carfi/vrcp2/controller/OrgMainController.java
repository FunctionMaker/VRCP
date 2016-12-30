package com.carfi.vrcp2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.query.MenuQuery;
import com.carfi.vrcp2.service.IOrgMenuService;

/** 
* 
* @Description: 组织用户登录后主页控制器
* @author gjw 
* 
*/
@Controller
@RequestMapping("/org/index")
public class OrgMainController {
	@Autowired
	private IOrgMenuService orgMenuService;
	/**  
	*  
	* @Description: 登录成功后跳转到主页
	* @param session
	* @param request
	* @return String
	*  
	*/  
	@RequestMapping("/main")
	public String main(HttpSession session,HttpServletRequest request){
		OrgUser orgUser = (OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION);
		OrgRole orgRole = orgUser.getOrgRole();
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.setParentId(null);
		menuQuery.setRoleId(orgRole.getId());
		request.setAttribute("menus", orgMenuService.queryAllByQuery(menuQuery));
		return "/org/main";
	}
}
