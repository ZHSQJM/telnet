package com.zhs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhs.mapper.TtPermissionMapper;
import com.zhs.mapper.TtRolePermissionMapper;
import com.zhs.pojo.TtAccount;
import com.zhs.pojo.TtPermission;
import com.zhs.pojo.TtRolePermission;
import com.zhs.pojo.TtUser;
import com.zhs.service.PermissionService;
import com.zhs.util.PageInfo;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/18 20:09
 * 描述:
 **/
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TtPermissionMapper permmissionDao;

    @Autowired
    private TtRolePermissionMapper tpDao;

    @Override
    @Transactional
    public  List<TtPermission>  loadAllPer(Map<String,Object> map) {

        List<TtPermission> list=new ArrayList<>();
        List<TtPermission> list1= permmissionDao.loadAllPer(map);
        for(TtPermission tt:list1){
              //根据资源的父资源取得下面的子资源
            List<TtPermission> ttPermission= permmissionDao.findPtByParentid(tt.getId());
           if(ttPermission!=null&&ttPermission.size()>0){
               tt.setList(ttPermission);
           }
            list.add(tt);
        }
        return list;
    }

    @Override
    public List<TtPermission> queryAll() {
        return permmissionDao.queryAll();
    }

    @Override
    @Transactional
    public ResultData addpermision(TtPermission ttPermission) {
        int sort=permmissionDao.maxsort();
        TtPermission tp=new TtPermission();
        tp.setCreatetime(new Date());
        tp.setUpdatetime(new Date());
        tp.setName(ttPermission.getName());
        if(ttPermission.getIcon()==null){
            tp.setIcon(ttPermission.getIcon());
        }
        tp.setPerms(ttPermission.getPerms());
        tp.setParentid(ttPermission.getParentid());
        tp.setResurl(ttPermission.getResurl());
        tp.setType(ttPermission.getType());
        tp.setDisable(0);
        tp.setSort(sort+1);
        permmissionDao.insert(tp);
        return ResultData.ofSuccess("");
    }
    @Override
    @Transactional
    public ResultData delPermission(int perid) {
        //删除权限的同时  将角色-权限表中的对应关系也删除

        //获取关联表中的该条权限的数据
        List<TtRolePermission> list=tpDao.selPermissinByRourseId(perid);

        //删除关联表的权限数据
        if(list.size()>0&&list!=null){
            for(TtRolePermission trp:list){
                tpDao.delURolePermission(trp.getId());
            }
        }

        permmissionDao.delPermission(perid);
        return ResultData.ofSuccess("");
    }

    @Override
    public ResultData updatePermission(TtPermission ttPermission) {
        ttPermission.setUpdatetime(new Date());
        permmissionDao.updateByPrimaryKeySelective(ttPermission);
        return ResultData.ofSuccess("");
    }

    @Override
    public ResultData findPerLevelOne(  TtPermission ttPermission,Integer currentPage, Integer pageSize) {

        Page<?> page=PageHelper.startPage(currentPage, pageSize);
        List<TtPermission> list1=permmissionDao.findPerLevelOne(ttPermission);
        List<TtPermission> list=new ArrayList<>();
        for(TtPermission tp:list1){

            if(tp.getParentid()==0){
                tp.setExt1("一级菜单");
            }else{
                TtPermission tt=  permmissionDao.selectByPrimaryKey(tp.getParentid());
                tp.setExt1("二级菜单");
                tp.setExt2(tt.getName());
            }
            list.add(tp);
        }


        com.github.pagehelper.PageInfo<TtPermission> pageInfo = new com.github.pagehelper.PageInfo<>(list1);
        return ResultData.ofSuccess(pageInfo);

    }
}
