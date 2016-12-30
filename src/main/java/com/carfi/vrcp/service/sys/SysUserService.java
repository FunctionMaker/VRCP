package com.carfi.vrcp.service.sys;

import com.carfi.vrcp.pojo.SysUser;

/**
 * 系统用户服务接口
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public interface SysUserService {

	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return
	 */
	public SysUser queryByUsername(String username);
	
}
