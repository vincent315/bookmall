package com.xzy.bookstore.controller;

import com.xzy.bookstore.pojo.TUser;
import com.xzy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @RequestMapping("/selectById")
    @ResponseBody
    public TUser selectUserById(long id){
        return userService.selectUserById(id);
    }
}
