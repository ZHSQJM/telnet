package com.zhs.controller.api;

import com.zhs.pojo.TtUser;
import com.zhs.service.UserService;
import com.zhs.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/20 17:24
 * 描述:
 **/

@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "这个用来测试用户相关的接口")
public class UserController {

    @Autowired
    private UserService userService;
//
    //分页获取用户列表
    @ApiOperation(value="分页查找用户列表", notes="返回的是分页回来的信息")
    @GetMapping(value="getAllUsers")
    public ResultData getAllUsers(TtUser user, @RequestParam(required = false, defaultValue = "1") int currentPage,
                                  @RequestParam(required = false, defaultValue = "5") int pageSize){
       // user.setRealname("周");
        return  userService.searchUser(user,currentPage,pageSize);
    }

    @ApiOperation(value="新增用户的接口", notes="返回的是是否添加成功")
    @PostMapping(value="add")
    public ResultData addUser(TtUser user){
        log.info("dasda0"+user);
        return  userService.addUser(user);
    }


    @PostMapping(value="del")
    @ApiOperation(value="删除用户的接口", notes="返回的是是否删除成功")
    public ResultData delUser(int id){
        return  userService.delUser(id);
    }


    @PostMapping(value="update")
    @ApiOperation(value="更新用户的接口", notes="返回的是是否更新成功")
    public  ResultData updateUser(@Validated  TtUser user){

        if(StringUtils.isEmpty(user.getId())){
            return ResultData.ofFail("请传入必传的参数");
        }
        return userService.updateUser(user);
    }

    @GetMapping(value="getUser")
    @ApiOperation(value="获取用户的接口", notes="返回的获取的用户信息成功")
    public  ResultData findUserById(Integer id){
        if(StringUtils.isEmpty(id)){
            return ResultData.ofFail("请传入必须参数");
        }
        return userService.findUserById(id);
    }

    @GetMapping(value="getRole")
    @ApiOperation(value="获取用户的角色的接口", notes="返回的获取的用户角色信息成功")
    public  ResultData findRoleById(Integer id){
        if(StringUtils.isEmpty(id)){
            return ResultData.ofFail("请传入必须参数");
        }
        return userService.findRoleByUserId(id);
    }

    @PostMapping(value="huifu")
    @ApiOperation(value="删除用户的接口", notes="返回的是是否删除成功")
    public ResultData huifuUser(int id){
        return  userService.huifuUser(id);
    }

    @GetMapping(value="getall")
    @ApiOperation(value="删除用户的接口", notes="返回的是是否删除成功")
    public ResultData getAll(TtUser user){
        return  userService.getAll(user);
    }
}
