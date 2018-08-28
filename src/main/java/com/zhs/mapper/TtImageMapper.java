package com.zhs.mapper;

import com.zhs.pojo.TtImage;

import java.util.List;

public interface TtImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtImage record);

    int insertSelective(TtImage record);

    TtImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtImage record);

    int updateByPrimaryKey(TtImage record);

    List<TtImage> searchImage(TtImage image);
}