package com.carfi.vrcp2.dao.sondao;

import java.util.List;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.Menu;
import com.carfi.vrcp2.query.MenuQuery;

/**
 * 菜单数据库持久层
 * @author ltx
 *
 */
public interface MenuDao extends BaseDao<Menu>{
	
	/**
	 * 通过父id查询所有该id下面的子菜单
	 * @param id
	 * @return
	 */
	List<Menu> queryAllByQuery(MenuQuery menuQuery);
	
}
