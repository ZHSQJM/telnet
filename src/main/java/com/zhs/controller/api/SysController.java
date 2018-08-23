package com.zhs.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/23 15:12
 * 描述: 页面跳转
 **/

@Controller
@RequestMapping("/sys")
@Slf4j
public class SysController {

    //用户列表页面
    @RequestMapping("/userlist")
    public  String userlist(){
        log.info("进入用户列表页面");
        return "user/userlist";
    }
    //角色列表
    @RequestMapping("/rolelist")
    public  String rolelist(){
        log.info("进入用户列表页面");
        return "role/rolelist";
    }
    //资源列表
    @RequestMapping("/perlist")
    public  String perlist(){
        log.info("进入用户列表页面");
        return "per/perlist";
    }

    //账号列表
    @RequestMapping("/acclist")
    public  String acclist(){
        log.info("进入用户列表页面");
        return "account/acclist";
    }
}
