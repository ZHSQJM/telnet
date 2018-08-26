package com.zhs.mapper;

import com.zhs.pojo.TtRole;

import java.util.List;

public interface TtRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtRole record);

    int insertSelective(TtRole record);

    TtRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtRole record);

    int updateByPrimaryKey(TtRole record);

    //根据用户的id查找该用户的角色
   List<TtRole> findRoleById(int userid);

   //删除角色
    void delRole(int roleid);

    //恢复角色
    void  huifuRole(int roleid);

    //分页显示角色列表
    List<TtRole> searchRole(TtRole role);

    //总记录数
    int count();
}