package com.zhs.base;

import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/5 21:35
 * 描述:自定义mapper接口
 **/
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

    ////FIXME 特别注意，该接口不能被扫描到，否则会出错
    //所有的mapper继承这个类之后就不需要写一些公共的代码
}
