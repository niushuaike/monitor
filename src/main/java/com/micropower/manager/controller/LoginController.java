package com.micropower.manager.controller;

import com.micropower.manager.model.po.User;
import com.micropower.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by niushuaike on 2017/9/21.
 */
@Controller
@RequestMapping("/monitorno")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/logo")
    public String login(Model model) {
        model.addAttribute("loginfail", "");
        return "logo";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user, Model model) {
        User user1 = userService.login(user);
        if (user1 != null) {
            request.getSession().setAttribute("user", user1);
            return "redirect:../jm/index";
        }
        model.addAttribute("loginfail", "登录失败！账号或用户名错误");
        return "redirect:../monitorno/logo";

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:../monitorno/logo";

    }

}
