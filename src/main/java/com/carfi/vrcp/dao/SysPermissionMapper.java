package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}