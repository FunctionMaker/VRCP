package com.carfi.vrcp2.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.OrgUserDao;
import com.carfi.vrcp2.dao.sondao.OrganizationDao;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.Organization;
import com.carfi.vrcp2.query.OrganizationQuery;
import com.carfi.vrcp2.service.IOrganizationService;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	private OrganizationDao orgDao;
	
	@Autowired
	private OrgUserDao orgUserDao;
	
	@Override
	public List<Organization> queryAllByQuery(OrganizationQuery query) {
		return orgDao.queryAllByQuery(query);
	}

	@Override
	public Integer queryTotalCountByQuery(OrganizationQuery query) {
		return orgDao.queryTotalCountByQuery(query);
	}

	@Override
	public Integer queryTotalCount() {
		return orgDao.queryTotalCount();
	}

	@Override
	public Organization queryOne(Serializable id) {
		return orgDao.queryOne(id);
	}

	@Override
	public List<Organization> queryAll() {
		return orgDao.queryAll();
	}

	@Override
	public void delete(Serializable id) {
		orgDao.delete(id);
	}

	@Override
	public void update(Organization organization) {
		orgDao.update(organization);
	}

	@Override
	public void setNotEffective(Long id) {
		orgDao.setNotEffective(id);
	}

	@Override
	public boolean saveOrgAndUser(Organization organization, OrgUser user) {
		if(user.getCreateBy()!=null){
			//设置父组织的has_son_node字段为1
			Organization parentOrganization = orgDao.queryOne(user.getCreateBy().getOrganization().getId());
			parentOrganization.setHasSonNode(true);
			orgDao.update(parentOrganization);
			//设置新增组织的层级
			organization.setLevel(parentOrganization.getLevel()+1);
		}else{
			//设置新增组织的层级
			organization.setLevel(1);
		}
		orgDao.save(organization);
		//给新增组织绑定超级管理员
		user.setOrganization(organization);
		orgUserDao.save(user);
		return true;
	}

	@Override
	public Serializable save(Organization organization) {
		return orgDao.save(organization);
	}

	@Override
	public Organization queryByOrganizationName(String organizationName) {
		return orgDao.queryByOrganizationName(organizationName);
	}

	@Override
	public void updOrgAndUser(Organization organization, OrgUser user) {
		orgDao.update(organization);
		orgUserDao.update(user);
	}

	@Override
	public void updOrgnization(Long id) {
		//先删除组织下的用户
		orgUserDao.updAll(id);
		//在删除组织
		orgDao.updOrgnization(id);
	}
	
	
}
