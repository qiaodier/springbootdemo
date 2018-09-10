package com.test.demo.controller;

import com.google.gson.Gson;

import com.test.demo.model.BaseRespBean;
import com.test.demo.model.UserTable;
import com.test.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;


/**
 * user 相关的controller
 */
@RestController
@RequestMapping(value = "/user")
public class Usercontroller {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    Gson gson;
    @Autowired
    UserService userService;

    /**
     * 获取所有用户
     *
     * @return list<UserTable>
     */
    @GetMapping(value = "/userList")
    public BaseRespBean<List<UserTable>> userTableList() {
        logger.info("获取所有用户信息request:=>");
        List<UserTable> resultList = userService.userTableList();
        BaseRespBean<List<UserTable>> baseRespBean = new BaseRespBean<>();
        if (resultList != null && resultList.size() > 0) {
            baseRespBean.setCode(0);
            baseRespBean.setMesg("成功");
            baseRespBean.setData(resultList);
        } else {
            baseRespBean.setCode(1);
            baseRespBean.setMesg("失败");
            baseRespBean.setData(new ArrayList<UserTable>());
        }
        logger.info("获取所有用户信息resp:=>" + gson.toJson(baseRespBean).toString());
        return baseRespBean;
    }

    /**
     * 根据主键id 查询用户
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/{id}")
    public BaseRespBean<UserTable> queryById(@PathVariable("id") Integer userId) {
        logger.info("通过id查数据request:=>userId:" + userId);
        UserTable userTable = userService.queryById(userId);
        BaseRespBean<UserTable> baseRespBean = new BaseRespBean<>();
        if (userTable != null) {
            baseRespBean.setMesg("成功");
            baseRespBean.setCode(0);
            baseRespBean.setData(userTable);
        } else {
            baseRespBean.setMesg("失败");
            baseRespBean.setCode(1);
            baseRespBean.setData(null);
        }
        String result = gson.toJson(baseRespBean).toString();
        logger.info("通过id查数据resp:=>" + result);
        return baseRespBean;
    }

    /**
     * 添加用户
     * @param userTable
     * @return
     */
    @PostMapping(value = "/add")
    public BaseRespBean add(@RequestBody UserTable userTable) {
        logger.info("添加用户request:=>"+gson.toJson(userTable).toString());
        BaseRespBean baseRespBean = new BaseRespBean();
        int result =userService.insertUser(userTable);
        if (result>0) {
            baseRespBean.setCode(0);
            baseRespBean.setMesg("成功");
        }else{
            baseRespBean.setCode(1);
            baseRespBean.setMesg("失败");
        }
        logger.info("添加用户resp:=>"+gson.toJson(baseRespBean).toString());
        return baseRespBean;
    }

    /**
     * 删除用户根据id
     * @param userId
     * @return
     */
    @GetMapping(value = "/delete")
    public BaseRespBean delete(Integer userId){
        logger.info("删除用户request:=>userId:"+userId);
        BaseRespBean baseRespBean = new BaseRespBean();
        int result = userService.deleteUser(userId);
        if (result>0){
            baseRespBean.setMesg("成功");
            baseRespBean.setCode(0);
        }else{
            baseRespBean.setMesg("失败");
            baseRespBean.setCode(1);
        }
        logger.info("删除用户resp:=>"+gson.toJson(baseRespBean).toString());
        return baseRespBean;
    }



}
