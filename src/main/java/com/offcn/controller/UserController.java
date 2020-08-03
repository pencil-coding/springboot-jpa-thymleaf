package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //查询全部用户数据
    @RequestMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("page",userList);
        return "user/list";
    }

    //点击添加按钮，跳转至用户添加页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    //添加用户
    @RequestMapping("/add")
    public String addUser(User user){
        userService.add(user);
        return "redirect:/";
    }

    //编辑用户
    @RequestMapping("/toEdit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        //准备回显数据
        User user = userService.findOne(id);
        model.addAttribute("user",user);

        return "user/userEdit";
    }

    //更新用户信息
    @RequestMapping("/update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/";
    }

    //回退
    @RequestMapping("/manageruser/")
    public String backToList(){
        return "redirect:/";
    }


    //删除用户信息
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }
}
