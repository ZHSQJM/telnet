package com.zhs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.mapper.TtAccountMapper;
import com.zhs.mapper.TtUserMapper;
import com.zhs.pojo.TtAccount;
import com.zhs.pojo.TtUser;
import com.zhs.service.AccountService;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 21:27
 * 描述:
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private TtAccountMapper accountMapper;

    @Autowired
    private TtUserMapper userDao;
    @Override
    public ResultData searchAccount(TtAccount account, Integer currentPage, Integer pageSize) {
        Page<?> page=PageHelper.startPage(currentPage, pageSize);
        List<TtAccount> list=accountMapper.searchAccount(account);
                log.info("查询到"+list.size());
      for(TtAccount ta:list){
          ta.setExt1( userDao.selectByPrimaryKey(ta.getUserid()).getRealname());
      }
        PageInfo<TtAccount> pageInfo = new PageInfo<>(list);
        return ResultData.ofSuccess(pageInfo);
    }

    @Override
    public ResultData searchAccountByUserId(TtAccount account, Integer currentPage, Integer pageSize) {
        log.info("通过用户名添加的"+account);
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        account.setUserid(user.getId());
        Page<?> page=PageHelper.startPage(currentPage, pageSize);
        List<TtAccount> list=accountMapper.searchAccount(account);
        log.info("查询到"+list.size());
        PageInfo<TtAccount> pageInfo = new PageInfo<>(list);
        return ResultData.ofSuccess(pageInfo);
    }

    @Override
    public ResultData addAccount(TtAccount ac,String realname) {
         TtAccount account=new TtAccount();
        Subject subject= SecurityUtils.getSubject();
        TtUser user=(TtUser) subject.getPrincipal();
        //说明时普通用户添加 //那么添加的账号数据是自己的 不展示输入姓名的框
        if(StringUtils.isEmpty(realname)){
            log.info("数据录入的用户的id是"+ac.getUserid());
            account.setUserid(user.getId());
        }else{
            TtUser user1=userDao.findUserByRealName(realname);
            log.info("根据真实姓名获取的用户是"+user1);
            if(user1==null){
                return  ResultData.ofFail("请先注册此用户");
            }
            account.setUserid(user1.getId());
        }
            account.setCreatetime(new Date());
            account.setUpdatetime(new Date());
            account.setWebsite(ac.getWebsite());
            account.setWebname(ac.getWebname());
            account.setUsername(ac.getUsername());
            account.setNickname(ac.getNickname());
            account.setPhone(ac.getPhone());
            account.setPassword(ac.getPassword());
            account.setDisabled("0");
            accountMapper.insert(account);
            log.info("添加成功");
        return ResultData.ofSuccess("");
        }

    }

