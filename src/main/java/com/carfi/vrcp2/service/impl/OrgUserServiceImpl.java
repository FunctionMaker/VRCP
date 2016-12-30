package com.carfi.vrcp2.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.OrgUserDao;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.query.OrgUserQuery;
import com.carfi.vrcp2.service.IOrgUserService;
@Service
public class OrgUserServiceImpl implements IOrgUserService {
	@Autowired
	private OrgUserDao orgUserDao;

	@Override
	public Long save(OrgUser t) {
		// TODO Auto-generated method stub
		return orgUserDao.save(t);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		orgUserDao.delete(id);
	}

	@Override
	public void update(OrgUser t) {
		// TODO Auto-generated method stub
		orgUserDao.update(t);
	}

	@Override
	public OrgUser queryOne(Serializable id) {
		// TODO Auto-generated method stub
		return orgUserDao.queryOne(id);
	}

	@Override
	public List<OrgUser> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrgUser queryLogin(String accountName, String password) {
		// TODO Auto-generated method stub
		return orgUserDao.queryLogin(accountName, password);
	}

	@Override
	public OrgUser queryOneByOrgId(long id) {
		// TODO Auto-generated method stub
		return orgUserDao.queryOneByOrgId(id);
	}

	@Override
	public boolean updateLoginTime(OrgUser orgUser) {
		orgUserDao.updateLoginTime(orgUser);
		return true;
	}

	@Override
	public Integer queryCountByOrgId(long orgId) {
		// TODO Auto-generated method stub
		return orgUserDao.queryCountByOrgId(orgId);
	}

	@Override
	public Integer queryCountByQuery(OrgUserQuery userQuery) {
		// TODO Auto-generated method stub
		return orgUserDao.queryCountByQuery(userQuery);
	}

	@Override
	public List<OrgUser> queryDataByQuery(OrgUserQuery userQuery) {
		// TODO Auto-generated method stub
		return orgUserDao.queryDataByQuery(userQuery);
	}

	@Override
	public OrgUser queryOrgUserByAccount(String accountName) {
		// TODO Auto-generated method stub
		return orgUserDao.queryOrgUserByAccount(accountName);
	}

	@Override
	public void updAll(Long orgId) {
		
	}
	

}
