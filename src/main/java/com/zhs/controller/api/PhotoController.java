package com.zhs.controller.api;

import com.qiniu.common.QiniuException;
import com.zhs.pojo.TtImage;
import com.zhs.pojo.TtUser;
import com.zhs.service.IQiNiuService;
import com.zhs.service.PhotoService;
import com.zhs.util.ResultData;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/28 14:55
 * 描述:
 **/

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private IQiNiuService qiNiuService;

    @Autowired
    private PhotoService photoService;

    @PostMapping("/add")
    public ResultData uploadImage(@RequestParam("file") MultipartFile multipartfile, TtImage image, HttpServletRequest request) throws IOException {
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        image.setUserid(user.getId());

        InputStream inputStream = multipartfile.getInputStream();
        //将MultipartFile文件转换，即写入File新文件中，返回File文件
       String url= qiNiuService.uploadFile(inputStream);
        image.setUrl(url);
        return  photoService.addImage(image);
    }

    @GetMapping("/searchImage")
    public ResultData searchImage(TtImage image, @RequestParam(required = false, defaultValue = "1") int currentPage,
                                  @RequestParam(required = false, defaultValue = "5") int pageSize)  {
        return  photoService.searchImage(image,currentPage,pageSize);
    }
}
