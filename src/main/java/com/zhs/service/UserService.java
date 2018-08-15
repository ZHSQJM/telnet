package com.zhs.service;

import com.zhs.pojo.TelnetUser;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 10:58
 * 描述:用户接口
 **/
public interface UserService  extends  IService<TelnetUser>{

    /*PageInfo<TelnetUser> selectByPage(TelnetUser user, int start, int length);



    void delUser(Integer userid);*/

    TelnetUser selectByUsername(String username);
}
