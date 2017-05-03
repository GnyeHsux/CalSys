package com.lcnet.lynn.dao.impl;

import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.BusiDao;
import com.lcnet.lynn.utils.StringUtil;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lynn on 2017/4/27.
 */

@Repository
public class BusiDaoImpl extends BaseDaoImpl implements BusiDao {
    public static final String fileName = "sqls/busi.sql";

    @Override
    public List<Record> getMyBusiList(String userId) {
        String str = this.getDao(fileName).sqls().get("getMyBusiList");
        Sql sql = Sqls.queryRecord(str);
        StringBuffer sb = new StringBuffer();
        if (userId != null){
            //sql.params().set("userId",userId);
            sb.append(" and bi.ownerid = '").append(userId).append("'");
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
    public List<Record> getBusiDetail(String busiId) {
        String str = this.getDao(fileName).sqls().get("getBusiDetail");
        Sql sql = Sqls.queryRecord(str);
        StringBuffer sb = new StringBuffer();
        sql.params().set("busiId",busiId);
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
}
