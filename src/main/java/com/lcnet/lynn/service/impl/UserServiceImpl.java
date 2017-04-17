package com.lcnet.lynn.service.impl;

import com.lcnet.lynn.dao.UserDao;
import com.lcnet.lynn.model.Users;
import com.lcnet.lynn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xusha on 2017/4/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    public Users findByAccAndPwd(String account, String pwd) {
        return userDao.findByAccAndPwd(account, pwd);
    }
}
