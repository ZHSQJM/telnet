package com.zhs.service;

import com.zhs.pojo.TtImage;
import com.zhs.util.ResultData;

import java.io.File;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/28 15:01
 * 描述:
 **/
public interface PhotoService {

    ResultData addImage(TtImage image);


    ResultData searchImage(TtImage image, Integer currentPage, Integer pageSize);
}
