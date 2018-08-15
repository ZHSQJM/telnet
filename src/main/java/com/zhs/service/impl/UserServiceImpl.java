package com.zhs.service.impl;

import com.zhs.pojo.TelnetUser;
import com.zhs.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 11:00
 * 描述:
 **/

@Service
public class UserServiceImpl  extends BaseService<TelnetUser> implements UserService  {

    //根据用户名查找用户
    @Override
    public TelnetUser selectByUsername(String username) {
        Example example = new Example(TelnetUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<TelnetUser> userList = selectByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
        return null;
    }
}
