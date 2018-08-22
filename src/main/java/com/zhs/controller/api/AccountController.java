package com.zhs.controller.api;

import com.zhs.pojo.TtAccount;
import com.zhs.util.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/21 11:34
 * 描述: 账号管理的相关api
 **/
@RestController
@RequestMapping("account")
public class AccountController {


    @GetMapping("list")
    public ResultData getAll(TtAccount account,@RequestParam(required = false, defaultValue = "1") int currentPage,
                             @RequestParam(required = false, defaultValue = "10") int pageSize){

        return  ResultData.ofSuccess("");

    }
}
