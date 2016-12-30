package com.carfi.vrcp.pojo;

import java.util.List;

/**
 * 当前登录用户信息
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public class SessionUser {

	/**id key*/
	private String id;
	/**当前用户信息*/
	private SysUser user;
	/**权限*/
	private List<String> pers;
	/**菜单*/
	private List<SysMenu> menus;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public List<String> getPers() {
		return pers;
	}
	public void setPers(List<String> pers) {
		this.pers = pers;
	}
	public List<SysMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SysMenu> menus) {
		this.menus = menus;
	}
	
	
}
