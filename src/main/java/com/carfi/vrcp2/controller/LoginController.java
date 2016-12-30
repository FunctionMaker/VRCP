package com.carfi.vrcp2.controller;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.User;
import com.carfi.vrcp2.service.IUserService;
import com.carfi.vrcp2.util.MD5Util;
import com.carfi.vrcp2.util.VerifyCodeUtils;

/**
 * 登录控制器
 * @author ltx
 *
 */
@RequestMapping("/carfi/login")
@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		return "/carfi/login";
	}
	
	@RequestMapping("/login")
	public String login(User  user,String verifyCode,HttpServletRequest req){
	
		User dbUser = userService.queryOneByName(user.getUsername());
		if(dbUser !=null && dbUser.getPassword().equals(MD5Util.string2MD5(user.getPassword()))){
			if(verifyCode.toLowerCase().equals(req.getSession().getAttribute(Constant.VERIFY_CODE))){
				req.getSession().setAttribute(Constant.USER_IN_SESSION, dbUser);
				User tempUser = new User();
				tempUser.setId(dbUser.getId());
				tempUser.setUsername(dbUser.getUsername());
				tempUser.setPassword(dbUser.getPassword());
				tempUser.setRole(dbUser.getRole());
				//设置最后一次登录时间
				tempUser.setLastLoginTime(new Date());
				userService.update(tempUser);
				return "redirect:/carfi/index/main";
			}else{
				req.setAttribute("errorInfo", "验证码不正确");
				return "/carfi/login";
			}
		}else{
			req.setAttribute("errorInfo", "用户名或密码不正确");
			return "/carfi/login";
		}
	}
	
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
	
	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(HttpServletResponse response,HttpSession session) throws IOException{	
		//创建四位验证码
		String code = VerifyCodeUtils.generateVerifyCode(4).toLowerCase();
		session.removeAttribute(Constant.VERIFY_CODE);
		session.setAttribute(Constant.VERIFY_CODE, code);
		VerifyCodeUtils.outputImage(100, 30, response.getOutputStream(), code);
	}
}
