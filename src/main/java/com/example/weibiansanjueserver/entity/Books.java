package com.example.weibiansanjueserver.entity;

import com.example.weibiansanjueserver.enums.BookStatusEnum;
import com.example.weibiansanjueserver.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createTime;

    @JsonIgnore
    public BookStatusEnum bookStatusEnum(){
        return EnumUtil.getByCode(bookStatus,BookStatusEnum.class );
    }

}
