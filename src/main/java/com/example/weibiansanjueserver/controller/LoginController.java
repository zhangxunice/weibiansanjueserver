package com.example.weibiansanjueserver.controller;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhangxu
 * @title 用户登录
 * @date 2019/10/10 16:01
 */

@RestController
public class LoginController {

    @GetMapping("/getcode")
    public String login(String code) throws IOException {
        String APPID = "wx094047c54a0a03e1";
        String SECRET = "feb08eb0414344647cb5f4bcc8c32377";
        String JSCODE = code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + APPID + "&secret=" + SECRET + "&js_code=" + JSCODE + "&grant_type=authorization_code";
        String openids = run(url);
        JSONObject jsonObject = JSONObject.parseObject(openids);
        // 获取到key为openid的值
        String openid = jsonObject.getString("openid");
        return openid;
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
}
