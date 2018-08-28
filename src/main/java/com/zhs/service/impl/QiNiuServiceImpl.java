package com.zhs.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zhs.service.IQiNiuService;
import com.zhs.upload.QiNiuProperties;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/27 11:01
 * 描述:
 **/
@Slf4j
@Service
public class QiNiuServiceImpl implements IQiNiuService, InitializingBean {


    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Autowired
    private QiNiuProperties qiNiuProperties;

    private StringMap putPolicy;

    private static String http="http://pe3momhpf.bkt.clouddn.com";

    @Override
    public String uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(file, null, getUploadToken());
            retry++;
        }
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        System.out.println(putRet.key);
        return http+"/"+putRet.key;
    }

    @Override
    public String uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return http+"/"+putRet.key;
    }
    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(qiNiuProperties.getBucket(), key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3) {
            response = bucketManager.delete(qiNiuProperties.getBucket(), key);
        }
        return response;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }

    private String getUploadToken() {
        return this.auth.uploadToken(qiNiuProperties.getBucket(), null, 3600, putPolicy);
    }
}
