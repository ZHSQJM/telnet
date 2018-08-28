package com.zhs.service;

import com.zhs.pojo.TtRole;
import com.zhs.pojo.TtUser;
import com.zhs.util.ResultData;

import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 9:02
 * 描述: 角色相关接口
 **/
public interface RoleService {

    //给角色分配权限
    ResultData AssginPermission(int roleid,String [] arr);

    //查找出这个角色的所有权限
    ResultData findPermissionByRoleId(int roleid);

    //添加角色
    ResultData addRole(TtRole role);

    //删除角色
    ResultData delRole(Integer id);
//分页获取角色列表
    ResultData searchRole(TtRole role, Integer currentPage, Integer pageSize);

    //更新角色
    ResultData updateRole(TtRole role);

    //恢复角色
    ResultData huifuRole(Integer id);

    //根据id查找角色
    ResultData getRole(Integer id);

    ResultData getUserByRoleId(int role);
}
