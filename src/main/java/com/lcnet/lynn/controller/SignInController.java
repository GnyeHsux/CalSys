package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lynn on 2017/4/21.
 */
@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestParam(value = "userAccount") String userAccount,@RequestParam(value = "userPwd") String userPwd) {
        ManUsers user = userService.findByAccAndPwd(userAccount, userPwd);
        if (user != null){
            return "nihao";
        }
        return null;
    }
}
