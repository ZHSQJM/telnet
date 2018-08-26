package com.zhs.mapper;

import com.zhs.pojo.TtUserRole;

import java.util.List;

public interface TtUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtUserRole record);

    int insertSelective(TtUserRole record);

    TtUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtUserRole record);

    int updateByPrimaryKey(TtUserRole record);

    //根据用户的id查找用户的角色
    List<TtUserRole> selbyuserid(Integer userid);


    //根据角色的id查找用户
    List<TtUserRole> selUseridByroleid(Integer id);

   void delUserRole(int roleid);

    void huifuUserRole(int roleid);
}