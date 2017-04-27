package com.lcnet.lynn.service.impl;

import com.lcnet.lynn.dao.RoleDao;
import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<ManRoles> findAll() {
        return roleDao.findAll();
    }
}
