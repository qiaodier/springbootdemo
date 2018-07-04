package com.test.demo.service;


import com.test.demo.model.UserTable;


import java.util.List;

public interface UserService  {

     List<UserTable> userTableList();

     UserTable queryById(int userId);
}
