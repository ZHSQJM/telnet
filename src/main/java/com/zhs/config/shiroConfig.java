package com.zhs.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.github.pagehelper.util.StringUtil;
import com.zhs.pojo.TtPermission;
import com.zhs.service.PermissionService;
import com.zhs.shiro.TtRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/17 14:39
 * 描述:shiro的配置类
 **/

@Configuration
@Slf4j
public class ShiroConfig {
    //创建shiroFilterFactorybean

    @Autowired
    private PermissionService permissionService;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
      ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
      shiroFilterFactoryBean.setSecurityManager(securityManager);
      //添加shiro的内置过滤器
      /*
      shiro内置过滤器。可以实现相关的拦截器
      常用的过滤器:
      anon:无需认证（登录）可以访问
      authc:必须认证才可以访问
      user:如果使用了remeberMe的功能可以直接访问
      perms:该资源必须得到资源权限才可以访问
      role:该资源必须得到角色权限才可以访问
       */
      Map<String,String> filterMap=new LinkedHashMap<String,String>();
      filterMap.put("/test","anon");
      filterMap.put("/js/**","anon");
      filterMap.put("/css/**","anon");
      filterMap.put("/favicon.ico","anon");
      filterMap.put("/fonts/**","anon");
      filterMap.put("/image/**","anon");
      filterMap.put("/assets/**","anon");
      filterMap.put("/login","anon");
      List<TtPermission> list=permissionService.queryAll();
      for(TtPermission tp: list) {
          if (StringUtil.isNotEmpty(tp.getResurl())) {
              String perm = "perms[" + tp.getPerms() + "]";
              filterMap.put(tp.getResurl(), perm);
          }
      }
      filterMap.put("/**","authc");
      //修改认证失败跳转的登录页面  默认的是login.jsp
      shiroFilterFactoryBean.setLoginUrl("/tologin");
      shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
      shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
      return  shiroFilterFactoryBean;
  }

    //创建DefaultWebSecurityManager
    @Bean(name ="securityManager" )
   public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("telnetRealm") TtRealm telnetRealm){
       DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //使用redis缓存
        securityManager.setCacheManager(cacheManager());
       //关联realm
       securityManager.setRealm(telnetRealm);

       return  securityManager;
   }


    //创建Realm
    @Bean(name = "telnetRealm")
    public TtRealm getRealm(){
        return  new TtRealm();
    }

    //添加shiro与thymeleaf的标签
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(timeout);
         redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
}
