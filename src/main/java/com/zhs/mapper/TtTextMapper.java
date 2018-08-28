package com.zhs.mapper;

import com.zhs.pojo.TtText;

import java.util.List;

public interface TtTextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtText record);

    int insertSelective(TtText record);

    TtText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtText record);

    int updateByPrimaryKeyWithBLOBs(TtText record);

    int updateByPrimaryKey(TtText record);
    List<TtText> queryAll( int id);

    TtText   findByTime(TtText record);
}