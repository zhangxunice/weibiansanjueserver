package com.example.weibiansanjueserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 10:38
 */

@Data
public class LoginForm {

    @NotEmpty(message = "账号不能为空", groups = {UserNameCheck.class})
    private String userName;

    @NotEmpty(message = "密码不能为空", groups = {PasswordCheck.class})
    private String password;
}
