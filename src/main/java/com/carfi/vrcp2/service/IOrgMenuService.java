package com.carfi.vrcp2.service;

import java.util.List;

import com.carfi.vrcp2.pojo.OrgMenu;
import com.carfi.vrcp2.query.MenuQuery;

public interface IOrgMenuService {
	List<OrgMenu> queryAllByQuery(MenuQuery menuQuery);//根据用户角色id查询用户拥有的菜单
}
