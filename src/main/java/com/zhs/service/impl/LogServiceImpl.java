package com.zhs.service.impl;

import com.zhs.mapper.TtLoginLogMapper;
import com.zhs.mapper.TtReqLogMapper;
import com.zhs.pojo.TtLoginLog;
import com.zhs.pojo.TtReqLog;
import com.zhs.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 17:26
 * 描述:日志实现
 **/
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private TtLoginLogMapper logDao;

    @Autowired
    private TtReqLogMapper reqDao;

    @Override
    public void addLoginLog(TtLoginLog ttLoginLog) {

        logDao.insert(ttLoginLog);
    }

    @Override
    public void addReqLog(TtReqLog reqLog) {
        reqDao.insert(reqLog);
    }
}
