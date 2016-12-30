package com.carfi.vrcp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carfi.vrcp.constant.Constant;
import com.carfi.vrcp.pojo.SessionUser;
import com.carfi.vrcp.util.CarfiUserUtil;
import com.carfi.vrcp.util.VerifyCodeUtils;

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
		SessionUser sessionUser = CarfiUserUtil.getSessionUser();
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
		//使doGetAuthorizationInfo执行
		SessionUser sessionUser = CarfiUserUtil.getSessionUser();
		SecurityUtils.getSubject().getSession().setTimeout(-1000l);
		SecurityUtils.getSubject().hasRole("test");
		model.addAttribute("menus",CarfiUserUtil.getMens());
		return "index";
	}
	
	/**
	 * 创建验证码
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(HttpServletResponse response,HttpSession session) throws IOException{	
		//创建四位验证码
		String code = VerifyCodeUtils.generateVerifyCode(4).toLowerCase();
		session.removeAttribute(Constant.VERIFY_CODE);
		session.setAttribute(Constant.VERIFY_CODE, code);
		VerifyCodeUtils.outputImage(100, 30, response.getOutputStream(), code);
	}
	
	/**
	 * 校验验证码
	 * @param verifyCode
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/validVerifyCode")
	public Map<String,Object> validVerifyCode(String verifyCode,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(verifyCode.toLowerCase().equals(session.getAttribute(Constant.VERIFY_CODE))){
			resultMap.put("valid", true);
			return resultMap;
		}else{
			resultMap = new HashMap<String,Object>();
			resultMap.put("valid", false);
		}
		return resultMap;
	}
	
}
