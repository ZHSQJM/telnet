package com.zhs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.mapper.TtImageMapper;
import com.zhs.pojo.TtAccount;
import com.zhs.pojo.TtImage;
import com.zhs.pojo.TtUser;
import com.zhs.service.PhotoService;
import com.zhs.util.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/28 15:02
 * 描述:
 **/
@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private TtImageMapper imageMapper;

    @Override
    public ResultData addImage(TtImage image) {

        image.setCreatetime(new Date());
                imageMapper.insert(image);
        return ResultData.ofSuccess("");
    }

    @Override
    public ResultData searchImage(TtImage image, Integer currentPage, Integer pageSize) {
        TtUser user=(TtUser) SecurityUtils.getSubject().getPrincipal();
        image.setUserid(user.getId());
        Page<?> page=PageHelper.startPage(currentPage, pageSize);
        List<TtImage> list=imageMapper.searchImage(image);
        log.info("查询到"+list.size());
        PageInfo<TtImage> pageInfo = new PageInfo<>(list);
        return ResultData.ofSuccess(pageInfo);

    }
}
