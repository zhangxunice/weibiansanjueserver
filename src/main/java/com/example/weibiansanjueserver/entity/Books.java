package com.example.weibiansanjueserver.entity;

import com.example.weibiansanjueserver.enums.BookStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/22 12:07
 */

@Data
public class Books {

    private String bookId;

    private String userId;

    private String bookName;

    private String bookIcon;

    private Integer bookStatus= BookStatusEnum.CHECK.getCode();

    private String bookDesc;

    private Integer bookFollows;

    private Date createTime;

}
