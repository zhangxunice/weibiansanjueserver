package com.example.weibiansanjueserver.vo;

import lombok.Data;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 15:34
 */
@Data
public class UserVO {

    private String userId;

    private String nickName;

    private String faceImage;

    private Integer bookCounts;

    private Integer fansCounts;

    private Integer followCounts;

    private Boolean isFollow=false;
}
