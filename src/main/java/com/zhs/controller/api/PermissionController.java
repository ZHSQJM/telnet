package com.zhs.controller.api;

import com.zhs.pojo.TelnetPermission;
import com.zhs.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/15 14:45
 * 描述: 资源控制类
 **/

@RestController
@RequestMapping("resources")
public class PermissionController {


    @Resource
    private PermissionService resourcesService;

    @RequestMapping("/loadMenu")
    public List<TelnetPermission> loadMenu(){
        Map<String,Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type",1);
        map.put("userid",userid);
        List<TelnetPermission> resourcesList = resourcesService.loadUserResources(map);
        return resourcesList;
    }
}
