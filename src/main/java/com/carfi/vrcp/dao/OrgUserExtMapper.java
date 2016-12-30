package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.OrgUserExt;

public interface OrgUserExtMapper {
    int deleteByPrimaryKey(String userExtId);

    int insert(OrgUserExt record);

    int insertSelective(OrgUserExt record);

    OrgUserExt selectByPrimaryKey(String userExtId);

    int updateByPrimaryKeySelective(OrgUserExt record);

    int updateByPrimaryKey(OrgUserExt record);
}