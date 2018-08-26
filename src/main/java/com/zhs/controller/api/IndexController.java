package com.zhs.controller.api;

import com.zhs.pojo.TtUser;
import com.zhs.service.LogService;
import com.zhs.util.ResultData;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/24 17:34
 * 描述: 首页的访问量图表统计
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private LogService logService;
    @GetMapping("pageview")
    public ResultData getPageview(){
        return logService.count();
    }

    //获取登录者的昵称
    @GetMapping("/userinfo")
    public ResultData getUser(){
       TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
           return ResultData.ofSuccess(user);
    }

}
