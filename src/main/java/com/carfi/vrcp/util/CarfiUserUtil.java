package com.carfi.vrcp.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.carfi.vrcp.pojo.SessionUser;
import com.carfi.vrcp.pojo.SysMenu;
import com.carfi.vrcp.pojo.SysOrganization;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.pojo.SysUser;

/**
 * session工具类
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public class CarfiUserUtil {

	/**
	 * 获取登录者所有信息
	 * @return
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取sessionUser
	 * @return
	 */
	public static SessionUser getSessionUser(){
		return (SessionUser)getSubject().getPrincipal();
	}
	/**
	 * 获取当前用户信息
	 * @return
	 */
	public static SysUser getSysUser(){
		return getSessionUser().getUser();
	}
	/**
	 * 获取当前用户权限
	 * @return
	 */
	public static List<String> getPermissions(){
		return getSessionUser().getPers();
	}
	/**
	 * 获取当前用户菜单
	 * @return
	 */
	public static List<SysMenu> getMens(){
		return getSessionUser().getMenus();
	}
	
	/**
	 * 获取当前用户组织信息
	 * @return
	 */
	public static SysOrganization getOrganization(){
		return getSessionUser().getOrganization();
	}
	/**
	 * 获取角色信息
	 * @return
	 */
	public static SysRole getRole(){
		return getSessionUser().getRole();
	}
}
