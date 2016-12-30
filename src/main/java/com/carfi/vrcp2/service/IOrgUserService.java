package com.carfi.vrcp2.service;

import java.util.List;

import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.query.OrgUserQuery;

public interface IOrgUserService extends IBaseService<OrgUser> {
	OrgUser queryLogin(String accountName,String password);//登录查询
	OrgUser queryOneByOrgId(long id);//根据组织id查询组织超级管理员
	boolean updateLoginTime(OrgUser orgUser);//更新用户登录时间
	Integer queryCountByOrgId(long orgId);//根据组织id查询组织的用户总记录数
	Integer queryCountByQuery(OrgUserQuery userQuery);//复杂查询时的用户总记录数
	List<OrgUser> queryDataByQuery(OrgUserQuery userQuery);//根据条件查询用户数据
	OrgUser queryOrgUserByAccount(String accountName);//根据账号查询该数据是否存在
	void updAll(Long orgId);//标记该组织，所有用户（包括超级管理员）的is_effective为false；
}
