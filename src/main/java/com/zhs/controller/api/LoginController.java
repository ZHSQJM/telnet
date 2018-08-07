package com.zhs.controller.api;

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
public class LoginController {

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }
}
