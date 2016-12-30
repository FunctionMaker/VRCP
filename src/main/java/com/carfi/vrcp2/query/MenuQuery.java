package com.carfi.vrcp2.query;

/**
 * 菜单查询条件
 * @author ltx
 *
 */
public class MenuQuery {
	
	//父级id
	private Long parentId;
	
	//角色id
	private Long roleId;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	

}
