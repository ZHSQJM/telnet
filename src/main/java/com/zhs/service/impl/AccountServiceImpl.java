package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhs.mapper.TtAccountMapper;
import com.zhs.mapper.TtUserMapper;
import com.zhs.pojo.TtAccount;
import com.zhs.pojo.TtUser;
import com.zhs.service.AccountService;
import com.zhs.util.PageInfo;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        int totalRecords=0;
        if(account.getWebname()==null||account.getPhone()==null||account.getWebsite()==null||account.getUsername()==null) {
            totalRecords = accountMapper.count();
        }
        PageHelper.startPage(currentPage, pageSize);
      List<TtAccount> list=  accountMapper.searchAccount(account);
        totalRecords=list.size();

        PageInfo<TtAccount> pageInfo=new PageInfo<>(totalRecords,currentPage,pageSize,list);
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

