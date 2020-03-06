package com.example.weibiansanjueserver.adminAPI;

import com.example.weibiansanjueserver.enums.ResultEnum;
import com.example.weibiansanjueserver.exception.MyException;
import com.example.weibiansanjueserver.form.LoginForm;
import com.example.weibiansanjueserver.form.UserCheckSequence;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

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

    @PostMapping("/tologin")
    public ModelAndView toLogin(@Validated({UserCheckSequence.class}) LoginForm loginForm, BindingResult bindingResult, Map map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("login",map);
        }
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();

        //封装用户数据
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(
                loginForm.getUserName(),loginForm.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return new ModelAndView("redirect:/admin/index");
        }catch (UnknownAccountException e){ //用户名不存在
            map.put("msg","账号不存在或错误");
            return new ModelAndView("login",map);
        }catch (IncorrectCredentialsException e){  //密码错误
            map.put("msg","密码错误");
            return new ModelAndView("login",map);
        }

    }


}
