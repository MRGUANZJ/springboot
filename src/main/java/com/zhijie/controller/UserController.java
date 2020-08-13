package com.zhijie.controller;

import com.zhijie.pojo.User;
import com.zhijie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/16/16:03
 * @Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/queryUserList")
    public String queryUserList(Model model) {
        List<User> userList = userService.queryUserList();
        model.addAttribute("emps",userList);
        return "emp/list";
    }

    @GetMapping("/queryUserById")
    public String queryUserById(Integer id,Model model) {
        User user = userService.queryUserById(id);
        model.addAttribute("emp",user);
        return "emp/list";

    }
    @GetMapping("/add")
    public String toAdd(Model model){
        return "emp/add";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        User userName = userService.queryUserName(user.getName());
        if (userName!=null){
            System.out.println(user);
            return "error/404";
        } else {
            System.out.println("user=>"+user);
            int addUser = userService.addUser(user);
            return "redirect:/queryUserList";
        }
    }

    //修改页面
    @GetMapping("/updateUser/{id}")
    public String toupdateEmp(@PathVariable("id")Integer id, Model model){
        User userId=userService.queryUserById(id);
        model.addAttribute("emp",userId);
        System.out.println(userId);
        return "emp/update";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        int updateUser = userService.updateUser(user);
        return "redirect:/queryUserList";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Integer id) {
        int deleteUser = userService.deleteUser(id);
        return "redirect:/queryUserList";
    }


}
