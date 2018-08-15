package com.zhs.service;

import com.zhs.pojo.TelnetPermission;

import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 11:08
 * 描述:
 **/
public interface PermissionService extends IService<TelnetPermission> {

    public List<TelnetPermission> queryAll();

    //根据用户的id查找用户的权限
    public List<TelnetPermission> loadUserResources(Map<String,Object> map);


   public List<TelnetPermission> findResourceByParentId(int parentid);



}
