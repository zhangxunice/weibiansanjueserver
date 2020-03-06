package com.example.weibiansanjueserver.form;

import javax.validation.GroupSequence;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 11:37
 */


@GroupSequence({UserNameCheck.class,PasswordCheck.class})
public interface UserCheckSequence {
}
