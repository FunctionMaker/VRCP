package com.carfi.vrcp.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp.constant.Type;
import com.carfi.vrcp.dao.SysPermissionMapper;
import com.carfi.vrcp.pojo.SysPermission;
import com.carfi.vrcp.service.sys.SysPermissionService;
/**
 * 系统权限服务实现
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionMapper permissionMapper;

	
	@Override
	public List<SysPermission> queryListByUserId(String userId) {
		List<SysPermission> pers = permissionMapper.selectByUserId(userId,Type.Permission.BUTTON.getId());
		return pers;
	}

	@Override
	public List<SysPermission> queryListByUserId(String userId, Type.Permission perType) {
		return permissionMapper.selectByUserId(userId,perType.getId());
	}
	
	@Override
	public List<String> queryPerCodeByUserId(String userId) {
		List<SysPermission> list = queryListByUserId(userId);
		List<String> res = new ArrayList<>();
		for (SysPermission per : list) {
			res.add(per.getPercode());
		}
		return res;
	}

	@Override
	public List<String> queryPerCodeByUserId(String userId, Type.Permission perType) {
		List<SysPermission> list = queryListByUserId(userId, perType);
		List<String> res = new ArrayList<>();
		for (SysPermission per : list) {
			res.add(per.getPercode());
		}
		return res;
	}




}
