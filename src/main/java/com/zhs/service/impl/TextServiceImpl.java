package com.zhs.service.impl;

import com.zhs.mapper.TtTextMapper;
import com.zhs.pojo.TtText;
import com.zhs.service.ITextService;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/27 14:37
 * 描述:
 **/
@Service
@Slf4j
public class TextServiceImpl implements ITextService {

    @Autowired
    private TtTextMapper textDao;

    @Override
    public ResultData add(TtText text) {
        TtText tt= textDao.findByTime(text);

        if(tt==null){
            log.info("没有查询到数据，新增见");
            return ResultData.ofSuccess(textDao.insert(text));
        }else{
            log.info("查询到数据，修改");
            log.info(text.getText());
            tt.setText(text.getText());
            log.info("da"+tt);
            return  ResultData.ofSuccess(textDao.updateByPrimaryKey(tt));
        }

    }

    @Override
    public ResultData getAll(Integer id) {
        return ResultData.ofSuccess(textDao.queryAll(id));
    }

    @Override
    public ResultData del(TtText text) {
       TtText tt= textDao.findByTime(text);
       textDao.deleteByPrimaryKey(tt.getId());
        return ResultData.ofSuccess("");
    }
}
