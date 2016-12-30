package com.carfi.vrcp2.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.service.IOrgUserService;
import com.carfi.vrcp2.util.MD5Util;

/** 
* 
* @Description:登录和退出控制器类
* @author gjw 
* 
*/
@Controller
@RequestMapping("/org/login")
public class OrgLoginAndLogoutController {
	@Autowired
	private IOrgUserService orgUserService;
	/**  
	*  
	* @Description: 跳转到登录页面
	* @param request
	* @return String
	*  
	*/  
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		return "/org/login";
	}
	/**  
	*  
	* @Description: 
	* @param orgUser
	* @param verifyCode
	* @param request
	* @return String
	*  
	*/  
	@RequestMapping("/login")
	public String login(OrgUser orgUser,  String verifyCode,HttpServletRequest request){
		if(!verifyCode.toLowerCase().equals(request.getSession().getAttribute(Constant.VERIFY_CODE))){
			request.setAttribute("errorInfo", "验证码不正确");
			request.setAttribute("accountName", orgUser.getAccountName());
			request.setAttribute("password", orgUser.getPassword());
			return "/org/login";
		}
		OrgUser dbOrgUser = orgUserService.queryLogin(orgUser.getAccountName(), MD5Util.string2MD5(orgUser.getPassword()));
		if(dbOrgUser!=null){
				request.getSession().setAttribute(Constant.ORG_USER_IN_SESSION, dbOrgUser);
				request.getSession().setAttribute(Constant.CURRENT_LOGIN_TIME, new Date());
				return "redirect:/org/index/main";
		}else{
			request.setAttribute("errorInfo", "用户名或密码不正确");
			return "/org/login";
		}
	}
	@RequestMapping("/out")
	public String logout(HttpSession session){
		OrgUser orgUser = (OrgUser)session.getAttribute(Constant.ORG_USER_IN_SESSION);
		orgUser.setLastLoginTime((Date)session.getAttribute(Constant.CURRENT_LOGIN_TIME));
		session.removeAttribute(Constant.ORG_USER_IN_SESSION);
		orgUserService.updateLoginTime(orgUser);
		return "redirect:/org/login/index";
	}
}
