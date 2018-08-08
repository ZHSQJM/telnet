package com.zhs.shiro;

import com.zhs.pojo.TelnetUser;
import com.zhs.service.ResourceService;
import com.zhs.service.RoleService;
import com.zhs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IDEA
 * author:zhouhuasheng
 * Date:2018/8/89:26
 * 描述:
 **/

@Slf4j
public class TelnetRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        TelnetUser user = userService.selectUserByName(username);
        if(user==null) throw new UnknownAccountException();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());
        return authenticationInfo;
    }
}
