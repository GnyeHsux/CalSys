package com.lcnet.lynn.dao;

import com.lcnet.lynn.model.ManUsers;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface UserDao {
    List<ManUsers> findAll();

    ManUsers findByAccAndPwd(String account, String pwd);
}
