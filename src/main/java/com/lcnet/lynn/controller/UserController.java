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
 * Created by xusha on 2017/4/14.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
   /* static Map<Integer, Users> users = Collections.synchronizedMap(new HashMap<Integer, Users>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Users> getUserList() throws MyException {
        List<Users> r = new ArrayList<Users>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "Users")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody Users user) {
        users.put(user.getUserId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUser(@PathVariable Integer id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "Users")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @RequestBody Users user) {
        Users u = users.get(id);
        u.setUserName(user.getUserName());
        u.setPhone(user.getPhone());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return "success";
    }*/

   @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(method = RequestMethod.GET)
    public List<ManUsers> getUserList() throws MyException{
        List<ManUsers> list = userService.findAll();
        return list;
   }
}
