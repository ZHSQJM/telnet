package com.zhs.service.impl;

import com.zhs.mapper.TelnetUserMapper;
import com.zhs.mapper.TelnetUserRoleMapper;
import com.zhs.pojo.TelnetUser;
import com.zhs.pojo.TelnetUserRole;
import com.zhs.service.UserService;
import com.zhs.util.ResultData;
import com.zhs.util.ResultDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService<TelnetUser> implements UserService {


    @Autowired
    private TelnetUserRoleMapper telnetUserRoleMapper;

    @Autowired
    private TelnetUserMapper telnetUserMapper;



    @Override
    @Transactional
    public ResultData saveTelnetUser(TelnetUser user) {

        Example example = new Example(TelnetUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        List<TelnetUser> userList =telnetUserMapper.selectByExample(example);
        if(userList.size()>0){
            return ResultDataUtil.success("用户名已被注册",user.getUsername());
        }
        //注册的用户默认的角色是普通用户 角色id是3
        TelnetUserRole tur=new TelnetUserRole();
        telnetUserMapper.insert(user);
        tur.setRid(3);
        tur.setUid(user.getId());
        telnetUserRoleMapper.insert(tur);
        return ResultDataUtil.success("添加成功",user);
    }
}
