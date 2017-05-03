package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.model.UserForm;
import com.lcnet.lynn.model.UserRolesRel;
import com.lcnet.lynn.service.RoleService;
import com.lcnet.lynn.service.UserService;
import com.lcnet.lynn.utils.StringUtil;
import com.sun.org.apache.regexp.internal.RE;
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

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public List<Record> getUserList(@RequestParam(required = false) String username,@RequestParam(required = false) String employeeId){
        List<Record> userLists = userService.getUserLists(username,employeeId);
        return userLists;
    }

    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    public Map<String,Object> getRoleLists(){
        Map<String,Object> map = new HashMap<>();
        List<ManRoles> rolesList = userService.getRoleList();
        map.put("rolesList",rolesList);
        return map;
    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public Map<String,Object> queryUser(String userId){
        Record user = userService.queryUser(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("manUser",user);
        return map;
    }

    @RequestMapping(value = "/getUserMenu",method = RequestMethod.GET)
    public List<Map<String,Object>> getUserMenu(String userId){
        List<Map<String,Object>> menuLists = new ArrayList<>();
        if (! StringUtil.isEmpty(userId)){
            List<Record> menuList = userService.getUserMenu(Integer.parseInt(userId));

            for (Record record:menuList){
                if (StringUtil.isEmpty(record.getString("menu_pcode"))){
                    String pMenuName = record.getString("menu_name");
                    String pMenuCode = record.getString("menu_code");

                    Map<String,Object> menuMap = new HashMap<>();
                    menuMap.put("title",pMenuName);
                    Map<String,Object> subMenu = new HashMap<>();
                    List<Record> subMenuList = userService.getSubMenu(pMenuCode);
                    for (Record rs:subMenuList){
                        subMenu.put("title",rs.getString("menu_name"));
                        subMenu.put("link",rs.getString("menu_code"));
                    }


                    menuMap.put("children",subMenu);
                    menuLists.add(menuMap);
                }
            }
        }

        return menuLists;
    }


    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    public Map<String,Object> saveOrUpdateUser(@RequestBody UserForm userForm){
        Map<String,Object> map = new HashMap<>();
        ManUsers manUsers = new ManUsers();
        UserRolesRel userRolesRel = new UserRolesRel();
        try {
            manUsers.setUserName(userForm.getUserName());
            manUsers.setUserAccount(userForm.getUserAccount());
            manUsers.setPhone(userForm.getPhone());
            manUsers.setUserPwd(userForm.getUserPwd());

            String userId = userForm.getUserId();
            //新增
            if (StringUtil.isEmpty(userId)){
                Boolean boo = userService.checkEmployeeId(userForm.getEmployeeId());
                if (boo){
                    map.put("code","0");
                    map.put("msg","工号已存在");
                    return map;
                }
                manUsers.setEmployeeId(userForm.getEmployeeId());

                userService.saveUser(manUsers);

                userRolesRel.setRoleId(Integer.parseInt(userForm.getUserRole()));
                userRolesRel.setUserId(manUsers.getUserId());
                roleService.saveUserRolesRel(userRolesRel);
                //成功
                map.put("code","1");
                map.put("msg","新增成功！");
            }else {
                //编辑
                manUsers.setUserId(Integer.parseInt(userId));
                Record oldManUser = userService.queryUser(userId);
                String newEmployeeId = userForm.getEmployeeId();
                if (! newEmployeeId.equals(oldManUser.getString("employee_id"))){
                    Boolean boo = userService.checkEmployeeId(userForm.getEmployeeId());
                    if (boo){
                        map.put("code","0");
                        map.put("msg","工号已存在");
                        return map;
                    }
                }
                manUsers.setEmployeeId(userForm.getEmployeeId());
                userService.updateUser(manUsers);
                userRolesRel = roleService.getUserRolesRel(userForm.getUserId());
                userRolesRel.setRoleId(Integer.parseInt(userForm.getUserRole()));
                roleService.updateUserRolesRel(userRolesRel);
                //成功
                map.put("code","1");
                map.put("msg","编辑成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            //失败
            map.put("code","0");
            map.put("msg","操作失败");
        }


        return map;
    }
}
