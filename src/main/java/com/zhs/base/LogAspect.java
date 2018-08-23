package com.zhs.base;

import com.zhs.pojo.TtLoginLog;
import com.zhs.pojo.TtReqLog;
import com.zhs.pojo.TtUser;
import com.zhs.service.LogService;
import com.zhs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 17:21
 * 描述: //登录日志以及请求日志
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;


    @Autowired
    private UserService userService;


    private  long start;//开始时间

    @Pointcut(value = "execution(* com.zhs.controller.api.LoginController.login(..))")
    public void webLog(){
    }
    //
    @Pointcut(value = "execution(* com.zhs.controller.*.*.*(..))")
    public void requestLog(){

    }

    //这是记录登录的日志
    @Before("webLog()")
    public void deBeforelogin(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
       String username= request.getParameter("username");
       TtUser user= userService.findUserByUserName(username);
        TtLoginLog tll=new TtLoginLog();
        tll.setLoginid(user.getId());
        tll.setLogintime(new Date());
        tll.setLoginname(user.getUsername());
        tll.setLoginip(request.getRemoteAddr());
        // 记录下请求内容
        logService.addLoginLog(tll);
    }

    //获取请求时间
    @Before("requestLog()")
    public void doBeforeRequest(){
        System.out.println("进入了请求之前的方法");
        start=System.currentTimeMillis();
    }
    //这是记录请求。的日志
    @After("requestLog()")
    public void deBeforeRequest(JoinPoint joinPoint) throws Throwable {
        System.out.println("进入了请求之后的方法");
        TtReqLog ttReqLog=new TtReqLog();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response=  attributes.getResponse();
        //请求路径
        String url=request.getRequestURL().toString();
        String way=request.getMethod();
        ttReqLog.setRequrl(url);
        ttReqLog.setWay(way);

        String method=joinPoint.getSignature().getName();
        ttReqLog.setMethod(method);
        Subject subject= SecurityUtils.getSubject();
        TtUser user=(TtUser)subject.getPrincipal();
        if(user!=null) {
            ttReqLog.setUsername(user.getUsername());
        }else{
            ttReqLog.setUsername(request.getParameter("username"));
        }
        //请求者的
        String ip=request.getRemoteAddr();
        ttReqLog.setIp(ip);
        int code=response.getStatus();
        ttReqLog.setCode(String.valueOf(code));
        long end = System.currentTimeMillis();
        long time=end-start;
        ttReqLog.setReqtime(new Date());
        ttReqLog.setTime(time);
        // 记录下请求内容
        logService.addReqLog(ttReqLog);
    }
}
