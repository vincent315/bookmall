package com.xzy.bookstore.service;

import com.xzy.bookstore.ServerResponse;
import com.xzy.bookstore.pojo.User;

public interface UserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

     ServerResponse<String> checkValid(String str, String type);
}
