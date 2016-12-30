package com.carfi.vrcp.service.sys;

import java.util.List;

import com.carfi.vrcp.constant.Type;
import com.carfi.vrcp.pojo.SysPermission;

/**
 * 系统权限服务接口
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public interface SysPermissionService {

	/**
	 * 根据用户id获取权限列表<br>
	 * 默认查询BUTTON
	 * @param userId
	 * @return
	 */
	public List<SysPermission> queryListByUserId(String userId);
	/**
	 * 获取权限列表
	 * @param userId 用户id
	 * @param perType 权限类型
	 * @return
	 */
	public List<SysPermission> queryListByUserId(String userId,Type.Permission perType);
	/**
	 * 获取权限code列表 <br>
	 * 默认查询BUTTON
	 * @param userId 用户id
	 * @return
	 */
	public List<String> queryPerCodeByUserId(String userId);
	/**
	 * 获取权限code列表
	 * @param userId 用户id
	 * @param perType 权限类型
	 * @return
	 */
	public List<String> queryPerCodeByUserId(String userId,Type.Permission perType);
}
