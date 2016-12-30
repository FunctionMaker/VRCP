package com.carfi.vrcp.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp.constant.Type;
import com.carfi.vrcp.dao.SysMenuMapper;
import com.carfi.vrcp.pojo.SysMenu;
import com.carfi.vrcp.pojo.SysPermission;
import com.carfi.vrcp.service.sys.SysMenuService;
import com.carfi.vrcp.service.sys.SysPermissionService;

/**
 * 系统菜单业务实现
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuMapper menuMapper;
	
	@Autowired
	private SysPermissionService permissionService;

	@Override
	public List<SysMenu> queryByUserId(String userId) {
		List<SysMenu> menus = new ArrayList<SysMenu>();
		List<SysPermission> list = permissionService.queryListByUserId(userId, Type.Permission.MENU);
		for (SysPermission menu : list) {
			if(StringUtils.isNotBlank(menu.getMenuId())){
				SysMenu sysMenu = menuMapper.selectByPrimaryKey(menu.getMenuId());
				if(sysMenu != null){
					menus.add(sysMenu);
				}
			}
		}
		return menus;
	}



}
