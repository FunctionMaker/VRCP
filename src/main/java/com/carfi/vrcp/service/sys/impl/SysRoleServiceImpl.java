package com.carfi.vrcp.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp.dao.SysRoleMapper;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.service.sys.SysRoleService;

/**
 * 系统角色业务实现
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper roleMapper;

	@Override
	public SysRole queryById(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

}
