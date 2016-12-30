package com.carfi.vrcp2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carfi.vrcp2.constant.Constant;

@Controller
@RequestMapping("/carfi/logout")
public class LogoutController {
	
	@RequestMapping("/index")
	public String logout(HttpSession session){
		session.removeAttribute(Constant.USER_IN_SESSION);
		return "redirect:/carfi/login/index";
	}
	
}
