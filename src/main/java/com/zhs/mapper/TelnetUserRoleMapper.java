package com.zhs.mapper;

import com.zhs.pojo.TelnetUserRole;

public interface TelnetUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelnetUserRole record);

    int insertSelective(TelnetUserRole record);

    TelnetUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelnetUserRole record);

    int updateByPrimaryKey(TelnetUserRole record);
}