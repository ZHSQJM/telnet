package com.zhs.mapper;

import com.zhs.pojo.TtAccount;

import java.util.List;

public interface TtAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtAccount record);

    int insertSelective(TtAccount record);

    TtAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtAccount record);

    int updateByPrimaryKey(TtAccount record);


    //模糊查找所有的用户
    List<TtAccount> searchAccount(TtAccount account);

    //总记录数
    int count();
}