package com.carfi.vrcp2.service;

import java.util.List;

import com.carfi.vrcp2.pojo.Menu;
import com.carfi.vrcp2.query.MenuQuery;

public interface IMenuService{
	
	/**
	 * 通过父id查询所有该id下面的子菜单
	 * @param id
	 * @return
	 */
	List<Menu> queryAllByQuery(MenuQuery menuQuery);

}
