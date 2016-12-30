package com.carfi.vrcp2.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.MenuDao;
import com.carfi.vrcp2.pojo.Menu;
import com.carfi.vrcp2.query.MenuQuery;
import com.carfi.vrcp2.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> queryAllByQuery(MenuQuery menuQuery) {
		
		List<Menu> menus = new ArrayList<Menu>();
		
		getAllMenus(menuQuery, menus);
		
		return menus;
	}
	
	private void getAllMenus(MenuQuery menuQuery,List<Menu> menus){
		
		List<Menu> tempMenus = menuDao.queryAllByQuery(menuQuery);
		if(tempMenus != null && !tempMenus.isEmpty()){
			menus.addAll(tempMenus);
			Iterator<Menu> tempMenuIterator = tempMenus.iterator();
			while(tempMenuIterator.hasNext()){
				Menu menu = tempMenuIterator.next();
				MenuQuery menuQuery2 = new MenuQuery();
				menuQuery2.setParentId(menu.getId());
				menuQuery2.setRoleId(menuQuery.getRoleId());
				getAllMenus(menuQuery2, menus);
			}
		}
		
	}
	
}
