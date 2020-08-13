package com.zhijie.controller;

import com.zhijie.pojo.User;
import com.zhijie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/** Created with IntelliJ IDEA. @Auther: zhijie @Date: 2020/06/14/23:47 @Description: */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
  @GetMapping("/user/login")
  public String login(
          @RequestParam("name")String name, @RequestParam("password")String password, Model model, HttpSession session) {
      User login = userService.login(name, password);
      //具体的业务
            if (login!=null){
                session.setAttribute("loginuser",name);
                 return "redirect:/main.html";
            }else {
                model.addAttribute("msg","账号或者密码错误");
                return "index";
            }
  }
    @RequestMapping("/user/logout")
    public String signout(HttpSession session){
       session.invalidate();
        return "redirect:/index.html";
    }
}
