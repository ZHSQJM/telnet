package com.zhs.controller.api;


import com.zhs.pojo.TelnetUser;
import com.zhs.service.UserService;
import com.zhs.util.MD5Utils;
import com.zhs.util.ResultData;
import com.zhs.util.ResultDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@Slf4j
@Api(value = "UserController|一个用来测试swagger注解的控制器")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增一个用户", notes = "新增用户")
    @PostMapping("saveUser")
    public ResultData saveTelnetUser(@Validated TelnetUser user) throws Exception{
        user.setPassword(MD5Utils.md5(user.getPassword()));
        return userService.saveTelnetUser(user);

    }
}
