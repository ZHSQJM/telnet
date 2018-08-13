package com.zhs.mapper;

import com.zhs.pojo.TelnetRolePermission;

public interface TelnetRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelnetRolePermission record);

    int insertSelective(TelnetRolePermission record);

    TelnetRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelnetRolePermission record);

    int updateByPrimaryKey(TelnetRolePermission record);
}