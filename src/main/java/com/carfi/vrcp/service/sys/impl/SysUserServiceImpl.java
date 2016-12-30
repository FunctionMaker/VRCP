package com.carfi.vrcp.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp.dao.SysRoleMapper;
import com.carfi.vrcp.dao.SysUserMapper;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.service.sys.SysUserService;

/**
 * 系统用户服务实现
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Override
	public SysUser queryByUsername(String username) {
		SysUser sysUser = userMapper.selectByUsername(username);
		return sysUser;
	}


}
