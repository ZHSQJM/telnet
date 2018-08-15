package com.zhs.controller.api;

import com.zhs.pojo.TelnetUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

        log.info("转发到首页");
        Subject subject = SecurityUtils.getSubject();
        TelnetUser sysUser = (TelnetUser) subject.getPrincipal();
        map.put("realname", sysUser.getUsername());
        return "index";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, TelnetUser user, Model model) {
            if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
                request.setAttribute("msg", "用户名或密码不能为空！");
                return "login";
            }
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            try {
                subject.login(token);
                return "redirect:index";
            }catch (LockedAccountException lae) {
                token.clear();
                request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
                return "login";
            } catch (AuthenticationException e) {
                token.clear();
                request.setAttribute("msg", "用户或密码不正确！");
                return "login";
            }
        }
}
