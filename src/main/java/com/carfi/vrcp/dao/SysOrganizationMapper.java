package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.SysOrganization;

public interface SysOrganizationMapper {
    int deleteByPrimaryKey(String organizationId);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(String organizationId);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
}