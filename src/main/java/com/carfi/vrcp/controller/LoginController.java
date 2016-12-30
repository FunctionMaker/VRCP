package com.carfi.vrcp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carfi.vrcp.util.CarfiUserUtil;

@Controller
public class LoginController {

	/**
	 * 登录页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request){
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			String message = "";
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				message = "账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				message = "用户名与密码不匹配";
			} else if ("randomCodeError".equals(exceptionClassName)) {
				message = "验证码错误";
			} else {
				message = "发生未知错误";
			}
			model.addAttribute("message", message);
		}
		return "login";
	}
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		Subject currentUser = SecurityUtils.getSubject();
		model.addAttribute("menus",CarfiUserUtil.getMens());
		return "index";
	}
}
