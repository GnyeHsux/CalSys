package com.lcnet.lynn.dao.impl;

import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.UserDao;
import com.lcnet.lynn.model.Users;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xusha on 2017/4/17.
 */
@Repository
public class UserDaoImol extends BaseDaoImpl implements UserDao {
    public static final String fileName = "sqls/user.sql";

    @Override
    public List<Users> findAll() {

        List<Users> userList = this.getDao().query(Users.class, null);
        return userList;
    }

    @Override
    public Users findByAccAndPwd(String account, String pwd) {
        String str = this.getDao(fileName).sqls().get("findByAccAndPwd");
        Sql sql = Sqls.queryEntity(str);
        sql.setEntity(this.getDao().getEntity(Users.class));
        sql.params().set("acc", account);
        sql.params().set("pwd", pwd);
        this.getDao().execute(sql);
        Users user = sql.getObject(Users.class);
        return user;
    }
}
