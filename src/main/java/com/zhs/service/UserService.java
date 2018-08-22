package com.zhs.service;

import com.zhs.pojo.TtUser;
import com.zhs.util.ResultData;

import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/18 20:05
 * 描述: 用户相关的接口
 **/
public interface UserService {


    TtUser findUserByUserName(String username);

    ResultData addUser(TtUser user);

    ResultData delUser(Integer id);

    ResultData searchUser(TtUser user,Integer currentPage,Integer pageSize);

    ResultData updateUser(TtUser user);

    ResultData findUserById(Integer id);

    ResultData findRoleByUserId(int userid);
}
