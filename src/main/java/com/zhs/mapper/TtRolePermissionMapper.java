package com.zhs.mapper;

import com.zhs.pojo.TtRolePermission;

import java.util.List;

public interface TtRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtRolePermission record);

    int insertSelective(TtRolePermission record);

    TtRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtRolePermission record);

    int updateByPrimaryKey(TtRolePermission record);

  List<TtRolePermission> selPermissinByRoleId(Integer id);

  void delURolePermission(int id);
}