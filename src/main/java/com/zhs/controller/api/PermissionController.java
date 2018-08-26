package com.zhs.controller.api;

import com.zhs.pojo.TtPermission;
import com.zhs.pojo.TtUser;
import com.zhs.service.PermissionService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/19 8:38
 * 描述:
 **/

@RestController
@RequestMapping("per")
@Api(value = "这是权限相关的接口的接口")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    //根据登录用于的id获取用户的左侧菜单
    @GetMapping("loadMenu")
    @ApiOperation(value="用来获取当前登录者的菜单权限", notes="显示左侧菜单的权限")
    public List<TtPermission> loadMenu(){
        Map<String,Object> map = new HashMap<>();
        TtUser user= (TtUser)SecurityUtils.getSubject().getPrincipal();
        map.put("type",1);
        map.put("userid",user.getId());
        map.put("parentid",0);
        return  permissionService.loadAllPer(map);
    }

    @PostMapping("add")
    @ApiOperation(value="添加权限", notes="增加的权限")
    public ResultData addPermission( @Validated TtPermission tttPermission){
         return permissionService.addpermision(tttPermission);
    }

    @GetMapping("del")
    @ApiOperation(value="删除权限", notes="删除的权限")
    public ResultData delPermission(Integer id){
        if(StringUtils.isEmpty(id)){
            return  ResultData.ofFail("请传入必传参数");
        }
        return permissionService.delPermission(id);
    }

    @GetMapping("update")
    @ApiOperation(value="修改权限", notes="修改权限是否成功")
    public ResultData updatePermission( @Validated TtPermission ttPermission){
        if(StringUtils.isEmpty(ttPermission.getId())){
            return  ResultData.ofFail("请传入必传参数");
        }
        return permissionService.updatePermission(ttPermission);
    }

    @GetMapping("/getAllPerms")
    @ApiOperation(value="查找所有的权限", notes="查找权限是否成功")
    public ResultData findPerLevelOne( TtPermission ttPermission , @RequestParam(required = false, defaultValue = "1") int currentPage,
                                       @RequestParam(required = false, defaultValue = "5") int pageSize ){
       // ttPermission.setName("管理");
        return permissionService.findPerLevelOne(ttPermission,currentPage,pageSize);
    }
}
