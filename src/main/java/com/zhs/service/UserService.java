package com.zhs.service;


import com.zhs.pojo.TelnetUser;
import com.zhs.util.ResultData;

public interface UserService extends IService<TelnetUser> {




    //保存一个用户
    ResultData saveTelnetUser(TelnetUser user);

}
