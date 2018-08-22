package com.zhs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangqj on 2017/4/21.
 */
@Controller
@Slf4j
@Api(value = "这是用来控制页面跳转的接口")
public class HomeController {

    @ApiOperation(value="跳转登录页面", notes="返回的是页面")
    @GetMapping(value="/tologin")
    public String login(){
        log.info("进入到登陆页面");
        return "login";
    }


    @ApiOperation(value="跳转首页", notes="返回的是页面")
    @GetMapping(value = {"/index","/"})
    public String index(){
        log.info("进入首页");
        return  "index";
    }
    @ApiOperation(value="跳转未授权的页面", notes="返回的是页面")
    @GetMapping("/unauthorized")
    public String forbidden(){
        return "403";
    }
}
