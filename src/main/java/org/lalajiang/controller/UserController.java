package org.lalajiang.controller;

import org.lalajiang.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Cookie cookie;
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/")
    public String test01() {
        return "success";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletResponse response, HttpServletRequest request, @RequestParam String name, @RequestParam String pwd, Model model) {
        if (userService.login(name, pwd)) {
            //写入cookie
            //cookie = new Cookie("llj_login", "true");
            //response.addCookie(cookie);

            //写入session
            HttpSession sessionName = request.getSession();
            sessionName.setAttribute("userName", name);
            return "欢迎登陆";
        } else {
            model.addAttribute("info", "登录失败");
            return "登录失败";
        }
    }

    @RequestMapping("/show")
    public String show() {
        return "user/userShow";
    }

}
