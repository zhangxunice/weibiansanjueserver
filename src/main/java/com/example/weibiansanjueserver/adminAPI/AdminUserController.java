package com.example.weibiansanjueserver.adminAPI;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Admin;
import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.enums.ResultEnum;
import com.example.weibiansanjueserver.form.AdminCheckSequence;
import com.example.weibiansanjueserver.form.AdminForm;
import com.example.weibiansanjueserver.form.LoginForm;
import com.example.weibiansanjueserver.form.UserCheckSequence;
import com.example.weibiansanjueserver.service.AdminRoleService;
import com.example.weibiansanjueserver.service.AdminService;
import com.example.weibiansanjueserver.service.RoleService;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.KeyUtil;

import javax.validation.Valid;
import java.util.List;
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

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/userlist")
    public ModelAndView userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "20") Integer size,
                                 Map map) {
        IPage<User> userIPage = userService.findAll(page, size);
        map.put("usersList", userIPage);
        map.put("currentPage", page);
        map.put("totalPage", new Long(userIPage.getPages()).intValue());
        return new ModelAndView("users/userList", map);
    }


    @GetMapping("/unauthorized")
    public ModelAndView unauthorized(Map map) {
        map.put("msg", "对不起，您没有权限操作此功能，请联系管理员授予权限！");
        map.put("url", "/admin/index");
        return new ModelAndView("common/error", map);
    }

    @GetMapping("/adminlist")
    public ModelAndView adminlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "20") Integer size,
                                  Map map) {
        IPage<Admin> adminIPage = adminService.findAll(page, size);
        map.put("adminList", adminIPage);
        map.put("currentPage", page);
        map.put("totalPage", new Long(adminIPage.getPages()).intValue());
        return new ModelAndView("users/admin", map);
    }


    @GetMapping("/addadmin")
    public ModelAndView addAdmin(@RequestParam(value = "adminId", required = false) String adminId, Map map) {
        if (!StringUtils.isEmpty(adminId)) {
            AdminVO adminVO = adminService.queryAdminById(adminId);
            map.put("adminVO", adminVO);
        }
        List<Role> roleList = roleService.findAll();
        map.put("roleList", roleList);
        return new ModelAndView("users/addAdmin", map);
    }

    @PostMapping("/addAdmin")
    public ModelAndView addAdmin(@Validated({AdminCheckSequence.class}) AdminForm adminForm, BindingResult bindingResult, Map map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("users/addAdmin", map);
        }

        if (!StringUtils.isEmpty(adminForm.getAdminId())) {
           adminRoleService.updateAdmin(adminForm);
            map.put("msg", "修改成功");
            map.put("url", "/admin/adminlist");
            return new ModelAndView("common/success", map);
        }
        //判断用户名是否存在
        Admin admin = adminService.queryByName(adminForm.getName());
        if (admin != null) {
            map.put("msg", "账号已存在");
            return new ModelAndView("users/addAdmin", map);
        }

        adminService.addAdmin(adminForm);

        map.put("msg", "添加成功");
        map.put("url", "/admin/adminlist");
        return new ModelAndView("common/success", map);

    }

}
