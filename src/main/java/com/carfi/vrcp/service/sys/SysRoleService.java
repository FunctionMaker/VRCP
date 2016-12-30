package com.carfi.vrcp.service.sys;

import com.carfi.vrcp.pojo.SysRole;

/**
 * 系统角色服务接口
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public interface SysRoleService {

	/**
	 * 查询角色信息
	 * @param roleId
	 * @return
	 */
	public SysRole queryById(String roleId);
	
}
