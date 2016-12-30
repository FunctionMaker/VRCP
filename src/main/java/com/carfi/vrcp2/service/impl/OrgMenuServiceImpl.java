package com.carfi.vrcp2.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.OrgMenuDao;
import com.carfi.vrcp2.pojo.OrgMenu;
import com.carfi.vrcp2.query.MenuQuery;
import com.carfi.vrcp2.service.IOrgMenuService;
@Service
public class OrgMenuServiceImpl implements IOrgMenuService {
	@Autowired
	private OrgMenuDao orgMenuDao;
	@Override
	public List<OrgMenu> queryAllByQuery(MenuQuery menuQuery) {
		List<OrgMenu> menus = new ArrayList<OrgMenu>();
		queryAllByQuery(menuQuery, menus);
		return menus;
	}

	public void queryAllByQuery(MenuQuery menuQuery,List<OrgMenu> menus){
		List<OrgMenu> tempMenus = orgMenuDao.queryAllByQuery(menuQuery);
		if(tempMenus != null && !tempMenus.isEmpty()){
			menus.addAll(tempMenus);
			Iterator<OrgMenu> tempMenuIterator = tempMenus.iterator();
			while(tempMenuIterator.hasNext()){
				OrgMenu menu = tempMenuIterator.next();
				MenuQuery menuQuery2 = new MenuQuery();
				menuQuery2.setParentId(menu.getId());
				menuQuery2.setRoleId(menuQuery.getRoleId());
				queryAllByQuery(menuQuery2, menus);
			}
		}
	}
}
