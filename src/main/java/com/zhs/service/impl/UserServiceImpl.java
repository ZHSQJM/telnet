package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.pojo.TelnetUser;
import com.zhs.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 11:00
 * 描述:
 **/

@Service
public class UserServiceImpl  extends BaseService<TelnetUser> implements UserService  {

    @Override
    public PageInfo<TelnetUser> selectByPage(TelnetUser user, int start, int length) {
            int page = start/length+1;
            Example example = new Example(TelnetUser.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtil.isNotEmpty(user.getUsername())) {
                criteria.andLike("username", "%" + user.getUsername() + "%");
            }
            if (user.getId() != null) {
                criteria.andEqualTo("id", user.getId());
            }
            if (user.getEnable() != null) {
                criteria.andEqualTo("enable", user.getEnable());
            }
            //分页查询
            PageHelper.startPage(page, length);
            List<TelnetUser> userList = selectByExample(example);
            return new PageInfo<>(userList);
    }

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
