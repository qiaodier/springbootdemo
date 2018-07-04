package com.test.demo.controller;

import com.alibaba.fastjson.JSON;
import com.test.demo.model.StepInfoBean;
import com.test.demo.model.UserTable;
import com.test.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Controller//处理http请求（需要与模板template 组合使用如果不使用模板的话，请求会报错，考虑到大多数项目返回的json，直接使用@RestController）
@RestController//Spring4之后加的注解，相当于@ResponseBody 和@Controller一起使用
@RequestMapping(value="/testController")//配置url映射，根据配置url路径找到该controller{如果需求想要多个路径都能访问该controller的话，就需要写成数组的形式  《{"/qiao","/hao"}》}
public class TestController {

    @Autowired
    private TestService service;
    //请求方法一定要指定get或者post 或者其他类型，不可不指定
    @RequestMapping(value = "/index/{id}",method =RequestMethod.GET)
    //上述mapping等价于 @GetMapping(value = "index/{id}")
    /**
     * @PathVariable 直接在url路径中取值
     * @RequestParams(value="id",required=false,defaultValue="0") 是在请求参数中取值,该注解可以设置当前所取参数是否必传，和默认值
     */
    public String index(@PathVariable("id") Integer id){
        return "id:"+id;
    }


    public static void main(String[] args) throws ParseException {

    }



}
