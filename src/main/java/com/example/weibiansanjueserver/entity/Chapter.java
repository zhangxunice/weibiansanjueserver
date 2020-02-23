package com.example.weibiansanjueserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/23 17:06
 */

@Data
public class Chapter {

    private String chapterId;
    private String bookId;
    private String userId;
    private String chapterTitle;
    private String chapterContent;
    private Date createTime;
}
