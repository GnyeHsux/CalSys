package com.lcnet.lynn.dao;

import org.nutz.dao.entity.Record;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface BusiDao {

    List<Record> getMyBusiList(String userId);

    List<Record> getBusiDetail(String busiId);
}
