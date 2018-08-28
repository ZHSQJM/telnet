package com.zhs.controller.api;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.zhs.pojo.TtUser;
import com.zhs.service.IQiNiuService;
import com.zhs.service.LogService;
import com.zhs.util.ResultData;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/24 17:34
 * 描述: 首页的访问量图表统计
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private LogService logService;

    @Autowired
    private IQiNiuService qiNiuService;

    @GetMapping("pageview")
    public ResultData getPageview(){
        return logService.count();
    }

    //获取登录者的昵称
    @GetMapping("/userinfo")
    public ResultData getUser(){
       TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
           return ResultData.ofSuccess(user);
    }


    @PostMapping("/upload")
    public ResultData uploadFile() throws QiniuException {
        String fileName = "E:\\bbb.jpg";
        File file = new File(fileName);
        //   assertTrue(file.exists());
        String imageurl = qiNiuService.uploadFile(file);

        //   assertTrue(response.isOK());
        //解析上传成功的结果
      //  DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
     //   System.out.println(putRet.key);//根据 http://域名/key 就能访问文件
        /*File file = new File(fileName);
        assertTrue(response.isOK());
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        System.out.println(putRet.key);//根据 http://域名/key 就能访问文件*/
return ResultData.ofSuccess(imageurl);
    }
}
