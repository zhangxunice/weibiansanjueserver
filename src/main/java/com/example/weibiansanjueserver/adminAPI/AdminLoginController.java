package com.example.weibiansanjueserver.adminAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/4 12:17
 */

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
