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
        return "user/userlist";
    }
    //角色列表
    @RequestMapping("/rolelist")
    public  String rolelist(){
        return "role/rolelist";
    }
    //资源列表
    @RequestMapping("/perlist")
    public  String perlist(){
        return "per/perlist";
    }

    //账号列表
    @RequestMapping("/acclist")
    public  String acclist(){
        return "account/acclist";
    }

    //账号列表
    @RequestMapping("/selflist")
    public  String selflist(){
        return "account/selflist";
    }

    //图片列表
    @RequestMapping("/photo")
    public  String photo(){
        return "photo/photo";
    }

    //记事本
    @RequestMapping("/text")
    public  String text(){
        return "text/text";
    }
}
