package com.carfi.vrcp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

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
}
