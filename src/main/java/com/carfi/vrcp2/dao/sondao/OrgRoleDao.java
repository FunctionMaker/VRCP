package com.carfi.vrcp2.dao.sondao;

import java.util.List;
import java.util.Map;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.OrgRole;

public interface OrgRoleDao extends BaseDao<OrgRole> {
	/**
	 * 根据组织id查询组织角色
	 * @param orgId 组织id
	 * @return
	 */
	List<OrgRole> queryAllByOrgId(Long orgId);
	/**
	 * 添加角色信息
	 * @param orgRole 角色信息
	 * @return 角色信息主键
	 */
	public Long addRole(OrgRole orgRole);
	/**
	 * 删除角色信息
	 * @param id 角色信息主键
	 */
	public void delete(Long id);
	/**
	 * 保存角色权限
	 * @param params roleId permissionId
	 */
	public void addRolePermission(Map<String,Object> params);
	/**
	 * 删除角色权限
	 * @param roleId 角色id
	 */
	public void deleteRolePermission(Long roleId);
	/**
	 * 根据组织ID和角色ID查询
	 * @param params roleId,orgId
	 * @return
	 */
	public OrgRole queryByOrgIdAndId(Map<String,Object> params);
	/**
	 * 修改组织角色
	 * @param orgRole
	 */
	public void updateById(OrgRole orgRole);
}
