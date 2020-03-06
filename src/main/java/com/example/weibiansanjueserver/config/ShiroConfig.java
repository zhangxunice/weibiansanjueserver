package com.example.weibiansanjueserver.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 19:59
 */
@Configuration
public class ShiroConfig {

    //1.创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器，进行权限相关的拦截
        /*anon:无需认证（登录）,直接可以访问
          authc:需认证（登录）,才可以访问
          user:如果使用remember me的功能可以直接访问
          perms:该资源必须的到资源权限才可访问
          role：该资源必须的到角色权限才可访问
         */
        Map<String,String> filterMap=new LinkedHashMap<>();
        filterMap.put("/admin/tologin", "anon");
        filterMap.put("/admin/adminlist","perms[admin]");
        //对管理端用户认证
        filterMap.put("/admin/**", "authc");

        //小程序端无序认证
        filterMap.put("/book/**", "anon");
        filterMap.put("/user/**", "anon");
        filterMap.put("/login/**", "anon");
        filterMap.put("/advice/**", "anon");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/admin/login");

        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/unauthorized");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    //2.注入 securityManager
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    //3.创建Realm
    @Bean
    public CustomRealm getRealm(){
        return new CustomRealm();
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
