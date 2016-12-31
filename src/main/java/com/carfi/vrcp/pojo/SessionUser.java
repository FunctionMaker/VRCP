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
	/**组织信息*/
	private SysOrganization organization;
	/**角色信息*/
	private SysRole role;
	
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
	public SysOrganization getOrganization() {
		return organization;
	}
	public void setOrganization(SysOrganization organization) {
		this.organization = organization;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	
	
}
