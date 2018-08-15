package com.zhs.service.impl;

import com.zhs.mapper.TelnetPermissionMapper;
import com.zhs.pojo.TelnetPermission;
import com.zhs.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 11:10
 * 描述:
 **/
@Service
public class PermissionServiceImpl extends  BaseService<TelnetPermission> implements PermissionService {

    @Resource
    private TelnetPermissionMapper permissionMapper;

    @Override
    public List<TelnetPermission> queryAll() {
        return permissionMapper.queryAll();
    }

    //根据用户的id和类型查找用户的权限
    @Override
    public List<TelnetPermission> loadUserResources(Map<String, Object> map) {
        List<TelnetPermission> levellist=new ArrayList<TelnetPermission>();
        List<TelnetPermission> list=permissionMapper.loadUserResources(map);
        //如果获取的菜单不为空的话  那么就查找出第一级菜单
        if(list.size()>0&&list!=null){
            for(TelnetPermission tp:list){
                     if(tp.getParentid()==0){//为一级菜单
                       int pid=tp.getId(); //获取一级菜单的id,根据这个父级菜单获取底下所有的二级菜单
                         List<TelnetPermission> list1= findResourceByParentId(pid);
                         tp.setList(list1);
                         levellist.add(tp);
                     }
            }
        }
                   return levellist;
    }

    @Override
    public List<TelnetPermission> findResourceByParentId(int parentid) {
        return permissionMapper.findResourceByParentId(parentid);
    }
}
