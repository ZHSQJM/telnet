package com.zhs.controller.api;

import com.zhs.util.MD5Utils;
import com.zhs.util.ResultData;
import com.zhs.util.ResultDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/810:44
 * 描述: 认证的api接口
 **/

@RestController
@Slf4j
@RequestMapping(value="/auth")
public class AuthController {


    @PostMapping("/login")
    public ResultData atuhUser(String username,String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResultDataUtil.success("用户名或密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,MD5Utils.md5 (password));
        try {
            subject.login(token);
        } catch (LockedAccountException lae) {
            token.clear();
            return ResultDataUtil.success("用户已经被锁定不能登录，请与管理员联系！");
        } catch (AuthenticationException e) {
            token.clear();
            return ResultDataUtil.success("用户或密码不正确！");
        }
        return  ResultDataUtil.success("验证成功");
    }
}
