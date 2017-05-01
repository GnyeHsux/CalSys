package com.lcnet.lynn.dao;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.ManUsers;
import org.nutz.dao.entity.Record;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface UserDao {
    List<ManUsers> findAll();

    ManUsers findByAccAndPwd(String account, String pwd);

    List<Record> getUserMenu(Integer userId);

    Record queryUser(String userId);

    List<Record> getUserLists(String username,String employeeId);

    ManUsers saveUser(ManUsers manUsers);

    ManUsers updateUser(ManUsers manUsers);

    List<Record> getSubMenu(String pMenuCode);

    List<ManRoles> getRoleList();
}
