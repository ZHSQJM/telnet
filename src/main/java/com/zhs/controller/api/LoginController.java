package com.zhs.controller.api;

import com.zhs.pojo.TtUser;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/20 17:19
 * 描述:
 **/
@RestController
@Slf4j
@Api(value = "这个用来测试登录的接口")
public class LoginController {

    @PostMapping(value="/login")
    @ApiOperation(value="测试登录的接口", notes="返回时登录是否成功")
    public ResultData login(TtUser user){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            log.info("用户名或密码不能为空！");
            return ResultData.ofFail("用户名或密码不能为空");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            subject.login(token);
            return ResultData.ofSuccess("");

    }
}
