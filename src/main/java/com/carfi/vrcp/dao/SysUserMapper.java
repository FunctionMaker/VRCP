package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
	SysUser selectByUsername(String username);
}