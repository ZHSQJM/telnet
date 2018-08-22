package com.zhs.mapper;

import com.zhs.pojo.TtUser;

import java.util.List;

public interface TtUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtUser record);

    int insertSelective(TtUser record);

    TtUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtUser record);

    int updateByPrimaryKey(TtUser record);

    TtUser findUserByUserName(String username);

    void delUser(Integer id);

    List<TtUser> searchUser(TtUser user);

   /* 查询总记录*/
    int count();
}