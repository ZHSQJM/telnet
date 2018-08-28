package com.zhs.service;

import com.zhs.pojo.TtText;
import com.zhs.util.ResultData;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/27 14:34
 * 描述:
 **/
public interface ITextService {



    ResultData add(TtText text);


    ResultData getAll(Integer id);

    ResultData del(TtText text);

}
