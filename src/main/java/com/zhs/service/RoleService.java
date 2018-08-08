package com.zhs.service;

import com.zhs.pojo.TelnetRole;

import java.util.List;


public interface RoleService extends  IService<TelnetRole>{

    List<TelnetRole> queryRoleListWithSelected(Integer id);
}
