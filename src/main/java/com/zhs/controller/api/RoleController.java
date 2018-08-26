package com.zhs.controller.api;

import com.zhs.pojo.TtRole;
import com.zhs.service.RoleService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 9:37
 * 描述: 角色相关api
 **/

@RestController
@RequestMapping("/role")
@Slf4j
@Api(value = "这个用来角色相关的接口")
public class RoleController {



    @Autowired
    private RoleService roleService;


    @PostMapping("/saveRolePer")
    @ApiOperation(value="给与角色分配权限", notes="返回的是分配是否成功信息")
    public ResultData AssginPermission(HttpServletRequest request){
        String roleid=request.getParameter("rid");
        String permission=request.getParameter("pid");
        if(StringUtils.isEmpty(roleid)||StringUtils.isEmpty(permission)){
            return ResultData.ofFail("请传入必传的参数");
        }
        String[] permissons = permission.split(",");
        return roleService.AssginPermission(Integer.valueOf(roleid),permissons);
    }

    //查找角色的权限
    @GetMapping("/permissions")
    @ApiOperation(value="查看角色的权限", notes="返回的是角色的权限信息")
    public  ResultData findPermissionByRoleId(Integer roleid){
        if(StringUtils.isEmpty(roleid)){
            return  ResultData.ofFail("请传入必传参数");
        }
         return  roleService.findPermissionByRoleId(roleid);
    }

    //添加用户
    @PostMapping("/add")
    @ApiOperation(value="添加用户", notes="返回的时用户是否添加成功")
    public ResultData addRole(@Validated TtRole role){
        return roleService.addRole(role);
    }


    //删除用户
    @PostMapping("/del")
    @ApiOperation(value="删除用户", notes="返回的时用户是否删除成功")
    public ResultData delRole( int roleid){
        if(StringUtils.isEmpty(roleid)){
            return ResultData.ofFail("请输入必传的参数");
        }
        return roleService.delRole(roleid);
    }

    //修改角色
    @PostMapping("/update")
    @ApiOperation(value="修改用户", notes="返回的时用户是否修改成功")
    public ResultData updateRole(@Validated TtRole role){
        if(StringUtils.isEmpty(role.getId())){
            return ResultData.ofFail("请传入必传的参数");
        }
        return roleService.updateRole(role);
    }

    //角色列表//模糊查询
    @GetMapping("/getAllRoles")
    @ApiOperation(value="删除用户", notes="返回的时用户是否删除成功")
    public ResultData getAllRoles(TtRole role, @RequestParam(required = false, defaultValue = "1") int currentPage,
    @RequestParam(required = false, defaultValue = "5") int pageSize){

        return roleService.searchRole(role,currentPage,pageSize);
    }

    //恢复角色的时候，无法恢复该觉得的权限 ，需要重新分配权限
    @PostMapping("/huifu")
    @ApiOperation(value="恢复角色", notes="返回的时用户是否恢复成功")
    public ResultData getAllRoles(int roleid){
        return roleService.huifuRole(roleid);
    }

    //恢复角色的时候，无法恢复该觉得的权限 ，需要重新分配权限
    @GetMapping("/getrole")
    @ApiOperation(value="恢复角色", notes="返回的时用户是否恢复成功")
    public ResultData getRole(int id){
        return roleService.getRole(id);
    }
}
