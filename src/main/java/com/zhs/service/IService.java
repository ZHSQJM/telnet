package com.zhs.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 10:57
 * 描述:通用接口
 **/

@Service
public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
