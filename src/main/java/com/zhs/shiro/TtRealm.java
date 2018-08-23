package com.zhs.shiro;

import com.zhs.pojo.TtPermission;
import com.zhs.pojo.TtUser;
import com.zhs.service.PermissionService;
import com.zhs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/17 14:42
 * 描述://自定义的realm
 **/
@Slf4j
public class TtRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        TtUser user= (TtUser) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",user.getId());

       List<TtPermission> list= permissionService.loadAllPer(map);
       for(TtPermission tp:list){
           info.addStringPermission(tp.getPerms());
       }
        return info;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken  token=(UsernamePasswordToken)authenticationToken;
       String name= token.getUsername();
        TtUser user=userService.findUserByUserName(name);
        if(user==null){
             return  null; //shiro会抛出异常unkonow
        }
        //password一定时数据库的密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
