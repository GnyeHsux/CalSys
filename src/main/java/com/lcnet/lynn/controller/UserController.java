package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.model.UserForm;
import com.lcnet.lynn.model.UserRolesRel;
import com.lcnet.lynn.service.RoleService;
import com.lcnet.lynn.service.UserService;
import com.lcnet.lynn.utils.StringUtil;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by lynn on 2017/4/14.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public List<Record> getUserList(){
        List<Record> userLists = userService.getUserLists();
        return userLists;
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public Map<String,Object> queryUser(String userId){
        Record user = userService.queryUser(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("manUser",user);
        return map;
    }

    @RequestMapping(value = "userAdd",method = RequestMethod.POST)
    public Map<String,Object> saveOrUpdateUser(UserForm userForm){
        Map<String,Object> map = new HashMap<>();
        ManUsers manUsers = new ManUsers();
        UserRolesRel userRolesRel = new UserRolesRel();
        try {
            manUsers.setUserName(userForm.getUserName());
            manUsers.setUserAccount(userForm.getUserAccount());
            manUsers.setEmployeeId(userForm.getEmployeeId());
            manUsers.setPhone(userForm.getPhone());
            manUsers.setUserPwd(userForm.getUserPwd());

            String userId = userForm.getUserId();
            if (StringUtil.isEmpty(userId)){
                userService.saveUser(manUsers);

                userRolesRel.setRoleId(Integer.parseInt(userForm.getUserRole()));
                userRolesRel.setUserId(manUsers.getUserId());
                roleService.saveUserRolesRel(userRolesRel);
            }else {
                manUsers.setUserId(Integer.parseInt(userForm.getUserId()));
                userService.updateUser(manUsers);
                userRolesRel = roleService.getUserRolesRel(userForm.getUserId());
                userRolesRel.setRoleId(Integer.parseInt(userForm.getUserRole()));
                roleService.updateUserRolesRel(userRolesRel);
            }

            //成功
            map.put("code","1");
        }catch (Exception e){
            e.printStackTrace();
            //失败
            map.put("code","0");
        }


        return map;
    }
}
