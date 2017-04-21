package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by xusha on 2017/4/14.
 */
@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        List<ManUsers> list = userService.findAll();
        ManUsers user = userService.findByAccAndPwd("1001", "123456");
        return "login";
    }


}
