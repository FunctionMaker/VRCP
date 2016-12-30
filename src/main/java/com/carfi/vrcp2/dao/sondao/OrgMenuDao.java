package com.carfi.vrcp2.dao.sondao;

import java.util.List;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.OrgMenu;
import com.carfi.vrcp2.query.MenuQuery;

public interface OrgMenuDao extends BaseDao<OrgMenu> {
	List<OrgMenu> queryAllByQuery(MenuQuery menuQuery);
}
