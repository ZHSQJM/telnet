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
//根据角色的id查找相对应的数据
  List<TtRolePermission> selPermissinByRoleId(Integer id);
  //根据权限的id查找相对应的数据
    List<TtRolePermission> selPermissinByRourseId(Integer id);


  void delURolePermission(int id);

  void huifuURolePermission(int id);
}