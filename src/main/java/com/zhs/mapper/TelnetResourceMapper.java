package com.zhs.mapper;

import com.zhs.base.BaseMapper;
import com.zhs.pojo.TelnetResource;

import java.util.List;

public interface TelnetResourceMapper extends BaseMapper<TelnetResource> {


    public List<TelnetResource> queryAll();
}