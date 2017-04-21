package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lynn on 2017/4/21.
 */
public class SignInController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public String signIn(@RequestParam(value = "useraccount") String useraccount,
                         @RequestParam(value = "userpwd") String userpwd) {
        ManUsers user = userService.findByAccAndPwd(useraccount, userpwd);
        if ("admin".equals(user.getUserName())){
            return "admin";
        }
        return "busman";
    }
}
