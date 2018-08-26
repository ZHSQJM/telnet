package com.zhs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangqj on 2017/4/21.
 */
@Controller
@Slf4j
@Api(value = "这是用来控制页面跳转的接口")
public class HomeController {

    @ApiOperation(value="跳转登录页面", notes="返回的是页面")
    @RequestMapping(value="/tologin")
    public String login(){
        log.info("进入登录页面");
        return "index/login";
    }
    @ApiOperation(value="跳转首页", notes="返回的是页面")
    @GetMapping(value = {"/index","/"})
    public String index(){
        return  "index/index";
    }
    @ApiOperation(value="跳转未授权的页面", notes="返回的是页面")
    @GetMapping("/unauthorized")
    public String forbidden(){
        return "403";
    }

    @ApiOperation(value="跳转注册的页面", notes="返回的是页面")
    @GetMapping("/register")
    public String register(){
        return "index/register";
    }
}
