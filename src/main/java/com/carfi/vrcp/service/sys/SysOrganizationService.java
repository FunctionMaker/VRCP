package com.carfi.vrcp.service.sys;

import java.util.List;

import com.carfi.vrcp.pojo.OrgUserExt;
import com.carfi.vrcp.pojo.PageDomain;
import com.carfi.vrcp.pojo.SysOrganization;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.query.OrganizationQuery;

/**
 * 组织Service
 * @author ltx
 *
 */
public interface SysOrganizationService {
	
	/**
	 * 根据查询条件查询组织
	 * @param orgQuery 查询条件
	 * @return 所有符合查询条件的组织
	 */
	List<SysOrganization> queryAllByQuery(OrganizationQuery orgQuery);
	
	/**
	 * 保存组织和组织超级管理员
	 * @param sysOrg 组织
	 * @param sysUser 组织超级管理员
	 */
	void saveOrgAndUser(SysOrganization sysOrg,SysUser sysUser,OrgUserExt orgUserExt);
	
	/**
	 * 修改组织和组织超级管理员
	 * @param sysOrg 组织
	 */
	void updateOrgAndUser(SysOrganization sysOrg,SysUser sysUser,OrgUserExt orgUserExt);
	
	/**
	 * 删除组织
	 * @param sysOrg
	 */
	void logicDeleteOrgById(String id);
	
	/**
	 * 通过id查询组织
	 * @param id 组织id
	 * @return 传入id对应的组织
	 */
	SysOrganization queryOrgById(String id);
	
	/**
	 * 查询组织数据
	 * @param organizationQuery
	 * @return
	 */
	PageDomain<SysOrganization> getDatas(OrganizationQuery orgQuery);
}
