package com.lcnet.lynn.dao;

import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.ManUsers;
import org.nutz.dao.entity.Record;

import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
public interface RoleDao {
    List<ManRoles> findAll();
}
