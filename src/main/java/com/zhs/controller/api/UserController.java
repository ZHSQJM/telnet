package com.zhs.controller.api;


import com.github.pagehelper.PageInfo;
import com.zhs.pojo.TelnetUser;
import com.zhs.service.UserService;
import com.zhs.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@Api(value = "UserController|一个用来测试swagger注解的控制器")
@RequestMapping("sys/user")
public class UserController {


    @Autowired
    private UserService userService;
    //用来获取登陆用户的所有菜单
        @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
        @GetMapping("/userlist")
        public Map<String,Object> getAll(TelnetUser user, String draw,
        @RequestParam(required = false, defaultValue = "1") int start,
        @RequestParam(required = false, defaultValue = "10") int length){
            Map<String,Object> map = new HashMap<>();
            PageInfo<TelnetUser> pageInfo = userService.selectByPage(user, start, length);
            System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
            map.put("draw",draw);
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("data", pageInfo.getList());
            return map;
    }


}
