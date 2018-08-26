package com.zhs.controller.api;

import com.zhs.pojo.TtAccount;
import com.zhs.service.AccountService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/22 21:19
 * 描述: 账号模块相关接口
 **/

@RestController
@RequestMapping("/account")
@Slf4j
@Api(value = "这个用来测试账号模块的接口")
public class AccountController {


    @Autowired
    private AccountService accountService;


    @GetMapping("/list")
    @ApiOperation(value="测试分页账号信息", notes="返回时登录是所有人的账号信息")
    public ResultData list(TtAccount account, @RequestParam(required = false, defaultValue = "1") int currentPage,
    @RequestParam(required = false, defaultValue = "5") int pageSize){
        return  accountService.searchAccount(account,currentPage,pageSize);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加账户数据",notes="返回的是是否添加成功")
    public ResultData addAccount(@Validated TtAccount account,String realname){
        return  accountService.addAccount(account,realname);
    }
    @GetMapping("/userlist")
    @ApiOperation(value="测试分页账号信息", notes="返回时登录是所有人的账号信息")
    public ResultData userlist(TtAccount account, @RequestParam(required = false, defaultValue = "1") int currentPage,
                           @RequestParam(required = false, defaultValue = "5") int pageSize){
        return  accountService.searchAccountByUserId(account,currentPage,pageSize);
    }


}
