package com.xzy.bookstore.service.impl;

import com.xzy.bookstore.mapper.TUserMapper;
import com.xzy.bookstore.pojo.TUser;
import com.xzy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper tUserMapper ;
    @Override
    public TUser selectUserById(long id) {
        return tUserMapper.selectByPrimaryKey(id);
    }
}
