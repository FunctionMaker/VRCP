package com.carfi.vrcp2.service;

import java.util.List;

import com.carfi.vrcp2.pojo.OrgPermission;

/**
 * 组织权限Service接口
 * @author jiangliuhong
 * @CREATEDATE 2016年12月21日
 */
public interface IOrgPermissionService {

	/**
	 * 根据组织id查询权限
	 * @param orgId 组织ID
	 * @return
	 */
	public List<OrgPermission> queryPermissionByOrgId(Long orgId);
	/**
	 * 根据角色id查询权限
	 * @param roleId 角色id
	 * @return
	 */
	public List<OrgPermission> queryPermissionByRoleId(Long roleId);
	/**
	 * 查询角色在该组织中所拥有的权限
	 * @param roleId 角色ID
	 * @param orgId 组织ID
	 * @return
	 */
	public List<OrgPermission> queryPermissionByRoleId(Long roleId,Long orgId);
}
