package com.zhs.service.impl;

import com.zhs.mapper.TelnetResourceMapper;
import com.zhs.pojo.TelnetResource;
import com.zhs.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/89:13
 * 描述:资源的实现类
 **/

@Service
public class ResourceServiceImpl extends BaseService<TelnetResource> implements ResourceService {

    @Autowired
    private TelnetResourceMapper resourceMapper;

    @Override
    public List<TelnetResource> queryAll() {
        return resourceMapper.queryAll();
    }
}
