package com.xzy.bookstore.controller;

import com.xzy.bookstore.Const;
import com.xzy.bookstore.ServerResponse;
import com.xzy.bookstore.pojo.User;
import com.xzy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户登录
     * @param username
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession httpSession){
        ServerResponse<User> response = userService.login(username, password);
        if(response.isSuccess()){
            httpSession.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }
    @RequestMapping(value = "logout.do",method = RequestMethod.GET)
    public ServerResponse<String> logOut(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }
    @RequestMapping(value = "register.do",method = RequestMethod.GET)
    public ServerResponse<String> register(User user){
        return userService.register(user);
    }
    @RequestMapping(value = "checkValid.do",method = RequestMethod.GET)
    public ServerResponse<String> checkValid(String str, String type){
        return userService.checkValid(str, type);
    }
}
