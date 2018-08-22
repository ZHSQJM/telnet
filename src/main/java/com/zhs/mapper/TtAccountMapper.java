package com.zhs.mapper;

import com.zhs.pojo.TtAccount;

public interface TtAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtAccount record);

    int insertSelective(TtAccount record);

    TtAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtAccount record);

    int updateByPrimaryKey(TtAccount record);
}