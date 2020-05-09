package com.example.weibiansanjueserver.config;

import com.example.weibiansanjueserver.entity.Admin;
import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.service.AdminService;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.utils.CookieUtil;
import com.example.weibiansanjueserver.utils.RedisConstant;
import com.example.weibiansanjueserver.vo.AdminVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Permissions;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 20:09
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Sid sid;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Subject subject= SecurityUtils.getSubject();
        AdminVO admin= (AdminVO) subject.getPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : admin.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            simpleAuthorizationInfo.addStringPermission(role.getPermissions());

        }
        return simpleAuthorizationInfo;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;

        AdminVO admin = adminService.queryAdmin(usernamePasswordToken.getUsername());


        //账号验证
        if (admin==null){
            return null;
        }

        //密码验证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin, admin.getPassword(), "");
        return simpleAuthenticationInfo;
    }
}
