package com.zhs.exception;

import com.zhs.util.ResultData;
import com.zhs.util.ResultDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/78:05
 * 描述:自定义异常
 **/
@ControllerAdvice
@Slf4j
@RestController
public class GlobalExceptionHandler {


    /**
     * 处理实体字段校验不通过异常
     * @param
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData defaultErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
        log.error("11111111111111111111111111111111111111111111111111111111111111111111111111", ex);
        String msg = "";
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            for (FieldError fieldErro : bindException.getBindingResult().getFieldErrors()) {
                msg =  fieldErro.getDefaultMessage() ;
            }
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            for (FieldError fieldErro : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
                msg = fieldErro.getDefaultMessage() ;
            }
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = (HttpRequestMethodNotSupportedException) ex;
            msg = httpRequestMethodNotSupportedException.getMessage();
        } else if (ex instanceof NoHandlerFoundException) {
            msg = "无效的请求地址";
        } else if (ex instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException) ex;
            msg = "缺少必要的参数[" + missingServletRequestParameterException.getMessage() + "]";
        } else if(ex instanceof AuthenticationException){
            msg="用户名密码错误";
        } else if(ex instanceof UnknownAccountException){
            msg="用户名不存在";
        }else {
            msg ="未知错误";
        }
        return  ResultDataUtil.error(msg,null);
    }
}
