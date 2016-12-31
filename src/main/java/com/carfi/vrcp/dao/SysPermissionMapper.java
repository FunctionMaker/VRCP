package com.carfi.vrcp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.carfi.vrcp.pojo.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    /**
     * 获取权限列表
     * @param userId 用户id
     * @param perType 权限类型
     * @return
     */
	List<SysPermission> selectByUserId(@Param("userId")String userId, @Param("perType")String perType);
	/**
	 * 获取权限列表
	 * @param roleId 角色id
	 * @return
	 */
	List<SysPermission> selectByRoleId(String roleId);
}