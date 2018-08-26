package com.zhs.mapper;

import com.zhs.pojo.TtReqLog;

public interface TtReqLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtReqLog record);

    int insertSelective(TtReqLog record);

    TtReqLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtReqLog record);

    int updateByPrimaryKey(TtReqLog record);
}