package com.zhs.mapper;

import com.zhs.pojo.TelnetPermission;

public interface TelnetPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelnetPermission record);

    int insertSelective(TelnetPermission record);

    TelnetPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelnetPermission record);

    int updateByPrimaryKey(TelnetPermission record);
}