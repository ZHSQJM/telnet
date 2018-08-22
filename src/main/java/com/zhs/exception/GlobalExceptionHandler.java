package com.zhs.exception;

import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/21 9:48
 * 描述: 全局异常捕获
 **/
@ControllerAdvice
@Slf4j
@RestController
public class GlobalExceptionHandler {


    //实体类上面的参数校验异常
    @ExceptionHandler(BindException.class)
    public ResultData handleBindException(BindException e) {
        log.error("参数绑定失败");
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = error.getDefaultMessage();
        return  ResultData.ofFail(message);
    }

    //shiro的异常捕获
    @ExceptionHandler(UnknownAccountException.class)
    public ResultData handleUnknownAccountException(Exception e){
            return ResultData.ofFail("用户名不存在");
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResultData handleAuthenticationException(Exception e){
        return ResultData.ofFail("用户或密码不正确！");
    }

 /*   @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e){
        return ResultData.ofFail("系统错误，请联系管理员！");
    }*/
}
