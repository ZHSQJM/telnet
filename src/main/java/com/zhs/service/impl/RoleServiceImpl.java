package com.zhs.service.impl;


import com.zhs.mapper.TelnetRoleMapper;
import com.zhs.pojo.TelnetRole;
import com.zhs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/89:31
 * 描述:角色的实现类
 **/

@Service
public class RoleServiceImpl extends  BaseService<TelnetRole> implements RoleService {

    @Autowired
    private TelnetRoleMapper roleMapper;

    @Override
    public List<TelnetRole> queryRoleListWithSelected(Integer id) {
        return roleMapper.queryRoleListWithSelected(id);
    }
}
