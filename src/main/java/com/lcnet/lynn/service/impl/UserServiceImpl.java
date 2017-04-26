package com.lcnet.lynn.service.impl;

import com.lcnet.lynn.dao.UserDao;
import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.service.UserService;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<ManUsers> findAll() {
        return userDao.findAll();
    }

    @Override
    public ManUsers findByAccAndPwd(String account, String pwd) {
        return userDao.findByAccAndPwd(account, pwd);
    }

    @Override
    public List<Record> getUserMenu(Integer userId) {
        return userDao.getUserMenu(userId);
    }
}
