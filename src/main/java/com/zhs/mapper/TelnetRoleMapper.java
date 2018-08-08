package com.zhs.mapper;

import com.zhs.base.BaseMapper;
import com.zhs.pojo.TelnetRole;

import java.util.List;

public interface TelnetRoleMapper extends BaseMapper<TelnetRole> {


    //根据用户的id查找出用户的角色
    List<TelnetRole> queryRoleListWithSelected(Integer id);
}