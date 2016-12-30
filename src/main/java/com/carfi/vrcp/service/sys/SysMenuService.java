package com.carfi.vrcp.service.sys;

import java.util.List;

import com.carfi.vrcp.pojo.SysMenu;

/**
 * 系统菜单服务接口
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public interface SysMenuService {
	/**
	 * 根据查询菜单
	 * @param userId 用户id
	 * @return
	 */
	public List<SysMenu> queryByUserId(String userId);
}
