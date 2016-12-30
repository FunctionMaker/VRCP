package com.carfi.vrcp2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.Role;
import com.carfi.vrcp2.pojo.User;
import com.carfi.vrcp2.query.MenuQuery;
import com.carfi.vrcp2.service.IMenuService;

/**
 * 主页控制器
 * @author ltx
 *
 */
@Controller
@RequestMapping("/carfi/index")
public class MainController {
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/main")
	public String main(HttpSession session,HttpServletRequest request){
		Role role =((User)session.getAttribute(Constant.USER_IN_SESSION)).getRole();
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.setParentId(null);
		menuQuery.setRoleId(role.getId());
		request.setAttribute("menus", menuService.queryAllByQuery(menuQuery));
		return "/carfi/main";
	}
}