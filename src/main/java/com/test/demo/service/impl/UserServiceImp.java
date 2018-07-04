package com.test.demo.service.impl;

import com.test.demo.mapper.UserTableMapper;
import com.test.demo.model.UserTable;
import com.test.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserTableMapper userTableMapper;
    @Override
    public List<UserTable> userTableList() {
        return userTableMapper.selectAll();
    }

    @Override
    public UserTable queryById(int userId) {
        UserTable userTable = userTableMapper.selectByPrimaryKey(userId);
        return userTable;
    }
}
