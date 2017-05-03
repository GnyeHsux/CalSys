package com.lcnet.lynn.service.impl;

import com.lcnet.lynn.dao.BusiDao;
import com.lcnet.lynn.service.BusiService;
import com.lcnet.lynn.service.RoleService;

import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by lynn on 2017/4/17.
 */
@Service
public class BusiServiceImpl implements BusiService {
    @Autowired
    private BusiDao busiDao;

    @Override
    public List<Record> getMyBusiList(String userId) {
        return busiDao.getMyBusiList(userId);
    }

    @Override
    public List<Record> getBusiDetail(String busiId) {
        return busiDao.getBusiDetail(busiId);
    }
}
