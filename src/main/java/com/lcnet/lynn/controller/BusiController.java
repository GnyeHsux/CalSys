package com.lcnet.lynn.controller;

import com.lcnet.lynn.dao.BusiDao;
import com.lcnet.lynn.service.BusiService;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lynn on 2017/4/27.
 */
@RestController
@RequestMapping(value = "/busi")
public class BusiController {
    @Autowired
    private BusiService busiService;

    @RequestMapping(value = "/listBusi")
    public List<Record> getMyBusiList(String userId){
        List<Record> myBusiList = busiService.getMyBusiList(userId);
        return  myBusiList;
    }
}
