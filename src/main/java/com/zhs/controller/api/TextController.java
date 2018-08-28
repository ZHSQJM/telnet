package com.zhs.controller.api;

import com.zhs.pojo.TtText;
import com.zhs.pojo.TtUser;
import com.zhs.service.ITextService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/27 14:42
 * 描述:
 **/

@RestController
@RequestMapping("/text")
@Api(value = "这是记事本的接口的接口")
@Slf4j
public class TextController {

    @Autowired
    private ITextService textService;

    @PostMapping("/getall")
    @ApiOperation(value="获取所有的接口", notes="返回时登录是否成功")
    public ResultData getall(){
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        return textService.getAll(user.getId());
    }


    @PostMapping("/add")
    @ApiOperation(value="新增的接口", notes="返回时登录是否成功")
    public ResultData add(TtText text){
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        text.setUserid(user.getId());
        return textService.add(text);
    }

    @PostMapping("/del")
    @ApiOperation(value="删除的接口", notes="返回是删除是否成功")
    public ResultData del(TtText text){
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        if(text.getText()==""||text.getText()==null){
            return ResultData.ofSuccess("");
        }
        text.setUserid(user.getId());
        return textService.del(text);
    }
}
