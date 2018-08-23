package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhs.mapper.TtPermissionMapper;
import com.zhs.mapper.TtRoleMapper;
import com.zhs.mapper.TtRolePermissionMapper;
import com.zhs.mapper.TtUserRoleMapper;
import com.zhs.pojo.*;
import com.zhs.service.RoleService;
import com.zhs.util.PageInfo;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/21 10:21
 * 描述: 用户接口实现层
 **/

@Service
@Slf4j
public class roleServerimpl implements RoleService {

    @Autowired
    private TtRoleMapper roleDao;

    @Autowired
    private TtRolePermissionMapper tpDao;

    @Autowired
    private TtPermissionMapper  permissionDao;

    @Autowired
    private TtUserRoleMapper trDao;

    @Override
    @Transactional
    public ResultData AssginPermission(int roleid, String [] arr) {

       //将该角色的用户查找出来
       List<TtPermission> list= permissionDao.findPermissinByroleId(roleid);

        //先将改角色的所有权限删除
       if(list.size()>0&&list!=null) {
           for (TtPermission tp:list) {
               tpDao.delURolePermission(tp.getId());

           }
       }
       if(arr.length>0&&arr!=null){
           for(int i=0;i<arr.length;i++){
               TtRolePermission trp=new TtRolePermission();
               trp.setCreatetime(new Date());
               trp.setRoleid(roleid);
               trp.setUpdatetime(new Date());
               trp.setDisable(0);
               trp.setResourcesid(Integer.valueOf(arr[i]));
               tpDao.insert(trp);
           }
           return ResultData.ofSuccess("");
        }else{
           return ResultData.ofFail("暂无分配的权限");
       }
    }

    @Override
    public ResultData findPermissionByRoleId(int roleid) {
        List<TtPermission> list= permissionDao.findPermissinByroleId(roleid);
        return ResultData.ofSuccess(list);
    }

    @Override
    public ResultData addRole(TtRole role) {
        TtRole tr=new TtRole();
        tr.setCreatetime(new Date());
        tr.setUpdatetime(new Date());
        tr.setRoledesc(role.getRoledesc());
        tr.setRolename(role.getRolename());
        tr.setDisable(0);
        roleDao.insert(tr);
        return ResultData.ofSuccess("");
    }

    @Override
    @Transactional
    public ResultData delRole(Integer id) {

        //删除角色的同时删除时用户相关表中的人
        //获取所有改角色的用户
        List<TtUserRole> list=trDao.selUseridByroleid(id);
        //删除用户的该种角色
        if(list.size()>0&&list!=null) {
            for (TtUserRole tr : list) {
                trDao.delUserRole(tr.getId());
            }
        }
        //获取该角色的所有权限
      List<TtRolePermission> list2= tpDao.selPermissinByRoleId(id);
        //删除该角色的所有权限
        if(list2.size()>0&&list2!=null) {
            for (TtRolePermission tr : list2) {
                log.info("da"+tr);
                tpDao.delURolePermission(tr.getId());
            }
        }
        //删除改种用户
        roleDao.delRole(id);
        return ResultData.ofSuccess("");
    }

    @Override
    public ResultData searchRole(TtRole role, Integer currentPage, Integer pageSize) {
        int totalRecords=0;
        if(role.getRolename()==null){
            totalRecords= roleDao.count();
        }
         PageHelper.startPage(currentPage, pageSize);
        List<TtRole> list= roleDao.searchRole(role);
        totalRecords=list.size();

        PageInfo<TtRole> pageInfo=new PageInfo<>(totalRecords,currentPage,pageSize,list);
        return ResultData.ofSuccess(pageInfo);
    }

    @Override
    public ResultData updateRole(TtRole role) {
        role.setUpdatetime(new Date());
        roleDao.updateByPrimaryKeySelective(role);
        return ResultData.ofSuccess("");
    }
}
