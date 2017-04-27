package com.lcnet.lynn.controller;

import com.lcnet.lynn.exception.MyException;
import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lynn on 2017/4/14.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public ManUsers queryUser(@RequestParam(value = "userId") String userId) throws MyException{
        ManUsers manUsers = userService.queryUser(userId);
        return manUsers;
   }
}
