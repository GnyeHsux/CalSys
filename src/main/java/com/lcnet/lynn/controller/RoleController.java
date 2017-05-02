package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.UserRolesRel;
import com.lcnet.lynn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lynn on 2017/4/27.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleList")
    public List<ManRoles> getRoleList(){
        List<ManRoles> rolesList = roleService.findAll();
        return rolesList;
    }

    @RequestMapping(value = "/getUserRole")
    public Map<String,Object> getUserRole(String userId){
        Map<String,Object> map = new HashMap<>();
        UserRolesRel userRolesRel = roleService.getUserRolesRel(userId);
        if (userRolesRel != null){
            map.put("code","1");
            map.put("roleId",userRolesRel.getRoleId());
            return map;
        }
        map.put("code","0");
        return map;
    }
}
