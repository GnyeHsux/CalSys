package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lynn on 2017/4/27.
 */

public class roleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleList")
    public List<ManRoles> getRoleList(){
        List<ManRoles> rolesList = roleService.findAll();
        return rolesList;
    }
}
