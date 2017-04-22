package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by lynn on 2017/4/21.
 */
@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public String signIn(ManUsers manUsers , HttpRequest request) {
        ManUsers user = userService.findByAccAndPwd(manUsers.getUserAccount(), manUsers.getUserPwd());
        if ("admin".equals(user.getUserName())){
            return "admin";
        }
        return "busman";
    }
}
