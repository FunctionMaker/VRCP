package com.carfi.vrcp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.OrgPermissionDao;
import com.carfi.vrcp2.pojo.OrgPermission;
import com.carfi.vrcp2.service.IOrgPermissionService;

/**
 * 组织权限Service实现
 * @author jiangliuhong
 * @CREATEDATE 2016年12月21日
 */
@Service
public class IOrgPermissionServiceImpl implements IOrgPermissionService {

	@Autowired
	private OrgPermissionDao orgPermissionDao;
	
	@Override
	public List<OrgPermission> queryPermissionByOrgId(Long orgId) {
		return orgPermissionDao.queryByOrgId(orgId);
	}

	@Override
	public List<OrgPermission> queryPermissionByRoleId(Long roleId) {
		return orgPermissionDao.queryByRoleId(roleId);
	}

	@Override
	public List<OrgPermission> queryPermissionByRoleId(Long roleId, Long orgId) {
		List<OrgPermission> result = queryPermissionByOrgId(orgId);
		List<Long> ids = orgPermissionDao.queryPermissionIdByRoleId(roleId);
		//给角色权限绑定状态
		for (OrgPermission op : result) {
			if(ids.contains(op.getId())){
				op.setState(true);
			}
		}
		return result;
	}

	
	
}
