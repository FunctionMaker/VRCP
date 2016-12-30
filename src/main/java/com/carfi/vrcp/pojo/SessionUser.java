package com.carfi.vrcp.pojo;

import java.util.List;

/**
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public class SessionUser {

	private SysUser user;
	
	private List<SysPermission> pers;
	
	private List<SysMenu> menus;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public List<SysPermission> getPers() {
		return pers;
	}

	public void setPers(List<SysPermission> pers) {
		this.pers = pers;
	}

	public List<SysMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SysMenu> menus) {
		this.menus = menus;
	}
	
	
	
}
