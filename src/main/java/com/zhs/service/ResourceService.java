package com.zhs.service;

import com.zhs.pojo.TelnetResource;

import java.util.List;

public interface ResourceService extends  IService<TelnetResource>{

    //查找所有的资源
     List<TelnetResource> queryAll();
}
