package com.example.weibiansanjueserver.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/11 16:58
 */
public class CookieUtil {

    public static void setCookie(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
    }

//
//    //设置token至redis
//    String token=sid.nextShort();
//    Integer expire= RedisConstant.EXPIRE;
//        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),admin.getId(),expire, TimeUnit.SECONDS);
//
//    //设置token至cookie
//        CookieUtil.setCookie(response,"token",token,expire);

}
