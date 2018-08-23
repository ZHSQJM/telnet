package com.zhs.service;

import com.zhs.pojo.TtLoginLog;
import com.zhs.pojo.TtReqLog;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 17:26
 * 描述:日志相关接口
 **/
public interface LogService {


    //登录日志
    public void addLoginLog(TtLoginLog ttLoginLog);

    //请求路径
    public void addReqLog(TtReqLog reqLog);
}
