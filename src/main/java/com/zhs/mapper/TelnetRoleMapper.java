package com.zhs.mapper;

import com.zhs.pojo.TelnetRole;

public interface TelnetRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelnetRole record);

    int insertSelective(TelnetRole record);

    TelnetRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelnetRole record);

    int updateByPrimaryKey(TelnetRole record);
}