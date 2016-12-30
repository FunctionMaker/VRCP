package com.carfi.vrcp2.dao.sondao;


import java.util.List;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.Organization;
import com.carfi.vrcp2.query.OrganizationQuery;

public interface OrganizationDao extends BaseDao<Organization>{
	
	List<Organization> queryAllByQuery(OrganizationQuery query);
	Integer queryTotalCount();
	Integer queryTotalCountByQuery(OrganizationQuery query);
	void setNotEffective(Long id);
	Organization queryByOrganizationName(String organizationName);
	int updOrgnization(Long id);//更改组织的is_effective为falsef
}
