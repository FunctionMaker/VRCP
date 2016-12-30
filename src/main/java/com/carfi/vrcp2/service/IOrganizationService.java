package com.carfi.vrcp2.service;

import java.io.Serializable;
import java.util.List;

import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.Organization;
import com.carfi.vrcp2.query.OrganizationQuery;

public interface IOrganizationService {
	Organization queryOne(Serializable id);
	List<Organization> queryAll();
	List<Organization> queryAllByQuery(OrganizationQuery query);
	Integer queryTotalCount();
	Integer queryTotalCountByQuery(OrganizationQuery query);
	Serializable save(Organization organization);
	void delete(Serializable id);
	void update(Organization organization);
	void setNotEffective(Long id);
	boolean saveOrgAndUser(Organization organization,OrgUser user);//添加组织
	Organization queryByOrganizationName(String organizationName);
	void updOrgAndUser(Organization organization,OrgUser user);//更改组织
	void updOrgnization(Long id);//更改组织的is_effective为false同时将其所有用户的is_effective置为false
}
