package com.carfi.vrcp2.dao.sondao;

import java.util.List;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.OrgPermission;

/**
 * 组织权限数据接口
 * @author jiangliuhong
 * @CREATEDATE 2016年12月21日
 */
public interface OrgPermissionDao extends BaseDao<OrgPermission> {
	/**
	 * 根据组织获取权限
	 * @param orgId
	 * @return
	 */
	public List<OrgPermission> queryByOrgId(Long orgId);
	/**
	 * 根据角色id查询权限列表
	 * @param roleId 角色id
	 * @return
	 */
	public List<OrgPermission> queryByRoleId(Long roleId);
	/**
	 * 根据角色id查询权限列表<br>
	 * 只返回权限id
	 * @param roleId 角色id
	 * @return
	 */
	public List<Long> queryPermissionIdByRoleId(Long roleId);
}
