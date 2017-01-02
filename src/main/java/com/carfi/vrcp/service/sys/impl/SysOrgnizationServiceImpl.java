package com.carfi.vrcp.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp.dao.OrgUserExtMapper;
import com.carfi.vrcp.dao.SysOrganizationMapper;
import com.carfi.vrcp.dao.SysUserMapper;
import com.carfi.vrcp.pojo.OrgUserExt;
import com.carfi.vrcp.pojo.PageDomain;
import com.carfi.vrcp.pojo.SysOrganization;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.query.OrganizationQuery;
import com.carfi.vrcp.service.sys.SysOrganizationService;
import com.github.pagehelper.PageHelper;

/**
 * 组织Service实现
 * @author FunctionMaker
 *
 */
@Service
public class SysOrgnizationServiceImpl implements SysOrganizationService {
	
	//组织mapper
	@Autowired
	SysOrganizationMapper sysOrgMapper;
	
	//用户mapper
	@Autowired
	SysUserMapper sysUserMapper;
	
	//用户扩展表mapper
	@Autowired
	OrgUserExtMapper orgUserExtMapper;

	@Override
	public List<SysOrganization> queryAllByQuery(OrganizationQuery orgQuery) {
		PageHelper.startPage(orgQuery.getBeginIndex(), orgQuery.getPageNum());
		return sysOrgMapper.selectAllByQuery(orgQuery);
	}

	@Override
	public void saveOrgAndUser(SysOrganization sysOrg, SysUser sysUser,OrgUserExt orgUserExt) {
		//保存组织
		sysOrgMapper.insert(sysOrg);
		//设置用户的组织id
		sysUser.setOrganizationId(sysOrg.getOrganizationId());
		//保存用户扩展表
		orgUserExtMapper.insert(orgUserExt);
		//设置用户组织扩展表id
		sysUser.setUserExtId(orgUserExt.getUserExtId());
		//保存用户
		sysUserMapper.insert(sysUser);
	}

	@Override
	public void updateOrgAndUser(SysOrganization sysOrg,SysUser sysUser,OrgUserExt orgUserExt) {
		//修改组织
		sysOrgMapper.updateByPrimaryKey(sysOrg);
		//修改组织扩展
		orgUserExtMapper.updateByPrimaryKey(orgUserExt);
		//修改组织用户
		sysUserMapper.updateByPrimaryKey(sysUser);
	}

	@Override
	public void logicDeleteOrgById(String id){
		sysOrgMapper.logicDeleteByPrimaryKey(id);
	}

	@Override
	public SysOrganization queryOrgById(String id) {
		return sysOrgMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public PageDomain<SysOrganization> getDatas(
			OrganizationQuery orgQuery) {
		PageDomain<SysOrganization> pageDomain = new PageDomain<SysOrganization>();
		pageDomain.setData(queryAllByQuery(orgQuery));
		pageDomain.setRecordsFiltered(sysOrgMapper.selectCountByQuery(orgQuery));
		pageDomain.setRecordsTotal(sysOrgMapper.selectCountByQuery(new OrganizationQuery()));
		return pageDomain;
	}
	
	

}
