package com.zhs.mapper;

import com.zhs.pojo.TelnetPermission;
import com.zhs.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface TelnetPermissionMapper  extends MyMapper<TelnetPermission> {

    public List<TelnetPermission> queryAll();

    public List<TelnetPermission> loadUserResources(Map<String,Object> map);

   public List<TelnetPermission> findResourceByParentId(int parentid);
}