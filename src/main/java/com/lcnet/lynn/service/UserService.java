package com.lcnet.lynn.service;

import com.lcnet.lynn.model.ManUsers;
import org.nutz.dao.entity.Record;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface UserService {
    List<ManUsers> findAll();

    ManUsers findByAccAndPwd(String account, String pwd);

    List<Record> getUserMenu(Integer userId);

    Record queryUser(String userId);

    List<Record> getUserLists();

    void saveUser(ManUsers manUsers);

    void updateUser(ManUsers manUsers);
}
