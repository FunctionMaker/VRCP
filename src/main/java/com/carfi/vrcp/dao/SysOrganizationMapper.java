package com.carfi.vrcp.dao;

import java.util.List;

import com.carfi.vrcp.pojo.SysOrganization;
import com.carfi.vrcp.query.OrganizationQuery;

public interface SysOrganizationMapper {
    int deleteByPrimaryKey(String organizationId);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(String organizationId);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
    
    /**
     * 通过查询条件查询所有符合查询条件的组织
     * @param orgQuery
     * @return
     */
    List<SysOrganization> selectAllByQuery(OrganizationQuery orgQuery);

    /**
     * 逻辑删除
     * @param organizationId
     */
    void logicDeleteByPrimaryKey(String organizationId);
    
    /**
     * 根据条件查询记录总数
     * @param orgQuery
     * @return
     */
    Integer selectCountByQuery(OrganizationQuery orgQuery);
    
}