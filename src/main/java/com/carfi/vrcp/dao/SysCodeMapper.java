package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.SysCode;

public interface SysCodeMapper {
    int deleteByPrimaryKey(String codeId);

    int insert(SysCode record);

    int insertSelective(SysCode record);

    SysCode selectByPrimaryKey(String codeId);

    int updateByPrimaryKeySelective(SysCode record);

    int updateByPrimaryKey(SysCode record);
}