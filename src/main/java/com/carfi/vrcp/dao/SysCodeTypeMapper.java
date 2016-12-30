package com.carfi.vrcp.dao;

import com.carfi.vrcp.pojo.SysCodeType;

public interface SysCodeTypeMapper {
    int deleteByPrimaryKey(String codeTypeId);

    int insert(SysCodeType record);

    int insertSelective(SysCodeType record);

    SysCodeType selectByPrimaryKey(String codeTypeId);

    int updateByPrimaryKeySelective(SysCodeType record);

    int updateByPrimaryKey(SysCodeType record);
}