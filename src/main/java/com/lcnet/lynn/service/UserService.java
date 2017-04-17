package com.lcnet.lynn.service;

import com.lcnet.lynn.model.Users;

import java.util.List;

/**
 * Created by xusha on 2017/4/17.
 */
public interface UserService {
    List<Users> findAll();

    Users findByAccAndPwd(String account, String pwd);
}
