package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import me.chanjar.weixin.common.util.StringUtils;
import org.nutz.dao.entity.Record;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lynn on 2017/4/21.
 */
@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public Map<String, Object> signIn(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "userPwd") String userPwd) {
        ManUsers user = userService.findByAccAndPwd(userAccount, userPwd);
        Map<String, Object> map = new HashMap<>();
        if (user != null){
            //成功
            map.put("code","1");
            map.put("user",user);
            //List<Record> menuList = userService.getUserMenu(user.getUserId());
            //map.put("menuList",menuList);
            return map;
        }
        //失败
        map.put("code",0);
        return map;
    }



}
