package com.zhs.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/718:37
 * 描述: 首页 注册页面跳转
 **/

@Controller
@Slf4j
public class LoginController {


    /**
    跳转登录页面 以及认证没有通过的页面
     */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        log.info("进入了登录页面");
        return "login";
    }
}
