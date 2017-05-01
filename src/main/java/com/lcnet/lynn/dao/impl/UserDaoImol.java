package com.lcnet.lynn.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.UserDao;
import com.lcnet.lynn.model.ManRoles;
import com.lcnet.lynn.model.ManUsers;
import com.lcnet.lynn.utils.StringUtil;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lynn on 2017/4/17.
 */
@Repository
public class UserDaoImol extends BaseDaoImpl implements UserDao {
    public static final String fileName = "sqls/user.sql";

    @Override
    public List<ManUsers> findAll() {

        List<ManUsers> userList = this.getDao().query(ManUsers.class, null);
        return userList;
    }

    @Override
    public ManUsers findByAccAndPwd(String account, String pwd) {
        String str = this.getDao(fileName).sqls().get("findByAccAndPwd");
        Sql sql = Sqls.queryEntity(str);
        sql.setEntity(this.getDao().getEntity(ManUsers.class));
        sql.params().set("acc", account);
        sql.params().set("pwd", pwd);
        this.getDao().execute(sql);
        ManUsers user = sql.getObject(ManUsers.class);
        return user;
    }

    @Override
    public List<Record> getUserMenu(Integer userId) {
        String str = this.getDao(fileName).sqls().get("findMenu");
        Sql sql = Sqls.queryRecord(str);
        sql.params().set("userId",userId);
        this.getDao().execute(sql);
        List<Record> records = sql.getList(Record.class);
        if (records != null && records.size()>0){
            return records;
        }
        return null;
    }

    @Override
    public Record queryUser(String userId) {
        String str = this.getDao(fileName).sqls().get("queryUser");
        Sql sql = Sqls.queryRecord(str);
        sql.params().set("userId", userId);
        this.getDao().execute(sql);
        List<Record> records = sql.getList(Record.class);
        if (records != null && records.size()>0){
            return records.get(0);
        }
        return null;
    }

    @Override
    public List<Record> getUserLists(String username,String employeeId) {
        String str = this.getDao(fileName).sqls().get("getUserLists");
        Sql sql = Sqls.queryRecord(str);
        StringBuffer sb = new StringBuffer();
        if (! StringUtil.isEmpty(username)){
            sb.append("and mu.user_name like '%").append(username).append("%'");
        }
        if (! StringUtil.isEmpty(employeeId)){
            sb.append(" and mu.employee_id like '%").append(username).append("%'");
        }
        if (! StringUtil.isEmpty(sb.toString())){
            sql.setCondition(Cnd.wrap(sb.toString()));
        }
        this.getDao().execute(sql);
        List<Record> records = sql.getList(Record.class);
        if (records != null && records.size()>0){
            return records;
        }
        return null;
    }

    @Override
    public ManUsers saveUser(ManUsers manUsers) {
        this.getDao().insert(manUsers);
        return manUsers;
    }

    @Override
    public ManUsers updateUser(ManUsers manUsers) {
        this.getDao().updateIgnoreNull(manUsers);
        return manUsers;
    }

    @Override
    public List<Record> getSubMenu(String pMenuCode) {
        String str = this.getDao(fileName).sqls().get("getSubMenu");
        Sql sql = Sqls.queryRecord(str);
        sql.params().set("pMenuCode",pMenuCode);
        this.getDao().execute(sql);
        List<Record> records = sql.getList(Record.class);
        if (records != null && records.size()>0){
            return records;
        }
        return null;
    }

    @Override
    public List<ManRoles> getRoleList() {
        List<ManRoles> rolesList = this.getDao().query(ManRoles.class, Cnd.wrap("id != '1'"));
        return  rolesList;
    }
}
