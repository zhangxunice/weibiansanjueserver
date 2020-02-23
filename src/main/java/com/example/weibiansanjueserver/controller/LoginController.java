package com.example.weibiansanjueserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.utils.JSONResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * @author zhangxu
 * @title 用户登录
 * @date 2019/10/10 16:01
 */

@RestController
public class LoginController {

    public static final String APPID = "wx1f28ea9e34a0740c";
    public static final String SECRET = "3299d9a320e36960292ecc5106ad541c";



    @Autowired
    private UserService userService;



    //获取用户的openId
    @GetMapping("/getcode")
    public String login(String code) throws IOException {
        String JSCODE = code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + APPID + "&secret=" + SECRET + "&js_code=" + JSCODE + "&grant_type=authorization_code";
        String openIds = run(url);
        JSONObject jsonObject = JSONObject.parseObject(openIds);
        // 获取到key为openid的值
        String openId = jsonObject.getString("openid");
        return openId;
    }

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    //添加新用户
    @PostMapping("saveuser")
    public JSONResult saveUser(@RequestBody User user){
        boolean userIsExist = userService.userIsExist(user.getUserId());
        if (userIsExist){
            userService.saveUser(user);
        }else {
            userService.updataUser(user);
        }
        return JSONResult.ok("添加成功");

    }



}
