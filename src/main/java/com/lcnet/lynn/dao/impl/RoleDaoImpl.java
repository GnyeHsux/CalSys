package com.lcnet.lynn.dao.impl;

import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.RoleDao;
import com.lcnet.lynn.model.ManRoles;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by xusha on 2017/4/27.
 */

@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

    @Override
    public List<ManRoles> findAll() {
        List<ManRoles> rolesList = this.getDao().query(ManRoles.class,null);
        return rolesList;
    }
}
