package com.zhs.service;

import com.zhs.pojo.TtPermission;
import com.zhs.util.ResultData;

import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/18 20:09
 * 描述:
 **/
public interface PermissionService {


    //根据登录用户的id的查找用户的权限
    List<TtPermission>  loadAllPer(Map<String,Object> map);

    //查找数据库中所有的权限
    List<TtPermission> queryAll();;


    //添加权限
    ResultData addpermision(TtPermission ttPermission);

    //删除权限
    ResultData delPermission(int perid);

    //更新权限
    ResultData updatePermission(TtPermission ttPermission);

    //查找所有的一级资源
    ResultData findPerLevelOne(TtPermission ttPermission,Integer currentPage, Integer pageSize);
}
