package com.zhs.controller.api;

import com.zhs.pojo.TelnetUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
    @GetMapping(value="/login")
    public String login(){
        log.info("进入了登录页面");
        return "login";
    }

    //进入了首页的地址
    @GetMapping(value = {"/", "/index"})
    public String index(Map map) {
        Subject subject = SecurityUtils.getSubject();
        TelnetUser sysUser = (TelnetUser) subject.getPrincipal();
        map.put("realname", sysUser.getRealname());
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) boolean remember, Map<String, Object> map) {
        UsernamePasswordToken upt = new UsernamePasswordToken(username, password, remember);
        Subject subject = SecurityUtils.getSubject();
        String errorMsg = null;
        try {
            subject.login(upt);
        } catch (LockedAccountException e) {
            errorMsg = "账号已被锁定，请联系管理员";
        } catch (AuthenticationException e) {
            log.error("Failed to login of username " + username + " with exception ", e);
            errorMsg = "用户名或者密码错误";
        }
        if (errorMsg != null) {
            map.put("errorMsg", errorMsg);
            return "login";
        }
        return "redirect:/index";
    }
}
