package com.example.weibiansanjueserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 16:57
 */

@Data
public class AdminForm {

    private String adminId;

    @NotEmpty(message = "账号不能为空", groups = {UserNameCheck.class})
    private String name;

    @NotEmpty(message = "密码不能为空", groups = {PasswordCheck.class})
    private String password;

    @NotEmpty(message = "角色不能为空", groups = {RoleCheck.class})
    private String[] roles;

}
