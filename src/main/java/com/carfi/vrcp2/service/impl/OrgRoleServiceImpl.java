package com.carfi.vrcp2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.OrgRoleDao;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.service.IOrgRoleService;
@Service
public class OrgRoleServiceImpl implements IOrgRoleService {
	
	@Autowired
	private OrgRoleDao orgRoleDao;
	
	@Override
	public Long save(OrgRole t) {
		orgRoleDao.addRole(t);
		return t.getId();
	}

	@Override
	public void delete(Long id) {
		//删除角色权限
		orgRoleDao.deleteRolePermission( id);
		//删除角色
		orgRoleDao.delete(id);
	}

	@Override
	public List<OrgRole> queryAllByOrgId(Long orgId) {
		return orgRoleDao.queryAllByOrgId(orgId);
	}

	@Override
	public void saveRolePermission(Long roleId, Long[] permissionId) {
		Map<String,Object> params = new HashMap<>();
		if(permissionId != null){
			if (permissionId.length > 0) {
				for (Long id : permissionId) {
					params.put("roleId", roleId);
					params.put("permissionId", id);
					orgRoleDao.addRolePermission(params);
				}
		}
		}
	}

	@Override
	public OrgRole query(Long id, Long orgId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roleId", id);
		params.put("orgId", orgId);
		return orgRoleDao.queryByOrgIdAndId(params );
	}

	@Override
	public void updateOrgRole(OrgRole orgRole, Long[] permissionId) {
		//修改角色信息
		orgRoleDao.updateById(orgRole);
		//修改角色权限
		//删除该角色原有权限
		orgRoleDao.deleteRolePermission(orgRole.getId());
		//新增角色权限
		saveRolePermission(orgRole.getId(),permissionId);
	}

}
