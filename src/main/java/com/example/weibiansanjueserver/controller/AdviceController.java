package com.example.weibiansanjueserver.controller;

import com.example.weibiansanjueserver.entity.Advice;
import com.example.weibiansanjueserver.service.AdviceService;
import com.example.weibiansanjueserver.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 13:40
 */

@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @PostMapping("/saveadvice")
    public JSONResult saveAdvice(@RequestBody Advice advice){
        adviceService.saveAdvice(advice);
        return JSONResult.ok("提交成功");
    }
}
