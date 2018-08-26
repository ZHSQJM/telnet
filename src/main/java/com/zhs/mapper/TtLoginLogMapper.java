package com.zhs.mapper;

import com.zhs.pojo.TtLoginLog;

public interface TtLoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtLoginLog record);

    int insertSelective(TtLoginLog record);

    TtLoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtLoginLog record);

    int updateByPrimaryKey(TtLoginLog record);

    //统计今天的访问量
    int count();
}