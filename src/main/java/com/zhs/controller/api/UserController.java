package com.zhs.controller.api;


import com.zhs.pojo.TelnetUser;
import com.zhs.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value = "UserController|一个用来测试swagger注解的控制器")
@RequestMapping("sys/user")
public class UserController {

    //用来获取登陆用户的所有菜单
    @PostMapping(value = "/menus")
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    public AjaxResult getUserMenu() {
        Subject subject = SecurityUtils.getSubject();
        TelnetUser sysUser = (TelnetUser) subject.getPrincipal();
        //return AjaxResult.ofSuccess(sysUser.getPermissionList());
        return  null;
    }
}
