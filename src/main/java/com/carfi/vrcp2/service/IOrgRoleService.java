package com.carfi.vrcp2.service;

import java.util.List;

import com.carfi.vrcp2.pojo.OrgRole;

public interface IOrgRoleService {
	/**
	 * 根据组织id查询组织所有角色
	 * @param orgId 根据组织id查询组织所有角色
	 * @return
	 */
	List<OrgRole> queryAllByOrgId(Long orgId);
	/**
	 * 保存角色权限
	 * @param roleId
	 * @param permissionId
	 */
	public void saveRolePermission(Long roleId,Long[] permissionId);
	/**
	 * 根据id获取角色信息
	 * @param id 角色id
	 * @param orgId 组织id
	 * @return
	 */
	public OrgRole query(Long id,Long orgId);
	/**
	 * 修改角色信息并修改角色权限
	 * @param orgRole 组织角色信息
	 * @param permissionId 权限数组
	 */
	public void updateOrgRole(OrgRole orgRole,Long[] permissionId);
	/**
	 * 保存
	 * @param orgRole
	 */
	public Long save(OrgRole orgRole);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Long id);
	
}
