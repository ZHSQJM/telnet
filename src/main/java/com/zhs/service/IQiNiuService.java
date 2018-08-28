package com.zhs.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.zhs.util.ResultData;

import java.io.File;
import java.io.InputStream;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/27 11:00
 * 描述:
 **/
public interface IQiNiuService {

    /**
     * 上传文件
     * <p>
     * (文件上传)
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    String uploadFile(File file) throws QiniuException;

    /**
     * 上传文件
     * <p>
     * (文件流上传)
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    String  uploadFile(InputStream inputStream) throws QiniuException;

    /**
     * 删除
     *
     * @param key
     * @return
     * @throws QiniuException
     */
    Response  delete(String key) throws QiniuException;
}
