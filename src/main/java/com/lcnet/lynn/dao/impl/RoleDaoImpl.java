package com.lcnet.lynn.dao.impl;

import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.RoleDao;
import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.UserRolesRel;
import org.nutz.dao.Cnd;
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

    @Override
    public void saveUserRolesRel(UserRolesRel userRolesRel) {
        this.getDao().insert(userRolesRel);
    }

    @Override
    public void updateUserRolesRel(UserRolesRel userRolesRel) {
        this.getDao().update(userRolesRel);
    }

    @Override
    public UserRolesRel getUserRolesRel(String userId) {
        List<UserRolesRel> list = this.getDao().query(UserRolesRel.class, Cnd.where("user_id","=",userId));
        if (list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
