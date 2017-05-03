package com.lcnet.lynn.service;


import org.nutz.dao.entity.Record;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface BusiService {

    List<Record> getMyBusiList(String userId);

    List<Record> getBusiDetail(String busiId);
}
