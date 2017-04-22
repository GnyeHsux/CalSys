package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by lynn on 2017/4/21.
 */
@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(String userAccount, String userPwd) {
        ManUsers user = userService.findByAccAndPwd(userAccount, userPwd);
        if ("admin".equals(user.getUserName())){
            return "admin";
        }
        return "busman";
    }
}
