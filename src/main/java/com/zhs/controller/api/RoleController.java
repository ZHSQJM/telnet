package com.zhs.controller.api;

import com.zhs.service.RoleService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/permissions")
    @ApiOperation(value="查看角色的权限", notes="返回的是角色的权限信息")
    public  ResultData findPermissionByRoleId(Integer roleid){
        if(StringUtils.isEmpty(roleid)){
            return  ResultData.ofFail("请传入必传参数");
        }
         return  roleService.findPermissionByRoleId(roleid);
    }
}
