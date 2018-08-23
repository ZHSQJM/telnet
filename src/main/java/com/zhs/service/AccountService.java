package com.zhs.service;

import com.zhs.pojo.TtAccount;
import com.zhs.util.ResultData;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 21:25
 * 描述:
 **/
public interface AccountService {

    //查询所有人的账号
    ResultData searchAccount(TtAccount account,Integer currentPage,Integer pageSize);

    //添加账号
    ResultData addAccount(TtAccount account,String realname);

}
