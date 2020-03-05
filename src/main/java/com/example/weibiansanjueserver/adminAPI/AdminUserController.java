package com.example.weibiansanjueserver.adminAPI;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 17:05
 */

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public ModelAndView userList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "size",defaultValue = "20")Integer size,
                                 Map map){
        IPage<User> userIPage = userService.findAll(page, size);
        map.put("usersList",userIPage);
        map.put("currentPage",page);
        map.put("totalPage",new Long(userIPage.getPages()).intValue());
        return new ModelAndView("users/userList",map);
    }
}
