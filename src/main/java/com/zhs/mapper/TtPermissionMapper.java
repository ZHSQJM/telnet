package com.zhs.mapper;

import com.zhs.pojo.TtPermission;
import com.zhs.pojo.TtRolePermission;

import java.util.List;
import java.util.Map;

public interface TtPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TtPermission record);

    int insertSelective(TtPermission record);

    TtPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TtPermission record);

    int updateByPrimaryKey(TtPermission record);

    List<TtPermission> loadAllPer(Map<String,Object> map);

    List<TtPermission> queryAll();

    List<TtPermission> findPtByParentid(Integer parentid);
    //根据用户的id查找用户的权限
    List<TtPermission> findPermissinByroleId(int roleid);
    //获取sort的最大值
    Integer maxsort();
//删除
    void delPermission(int perid);

    //获取所有的资源
    List<TtPermission> findPerLevelOne(TtPermission ttPermission);

    int count();

    List<TtPermission> findAllPer();
}