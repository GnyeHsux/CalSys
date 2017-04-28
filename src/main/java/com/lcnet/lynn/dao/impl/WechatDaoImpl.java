package com.lcnet.lynn.dao.impl;

import com.lcnet.lynn.dao.BaseDaoImpl;
import com.lcnet.lynn.dao.WeChatDao;
import com.lcnet.lynn.model.CustInfo;
import com.lcnet.lynn.model.CustWx;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xusha on 2017/4/27.
 */

@Repository
public class WechatDaoImpl extends BaseDaoImpl implements WeChatDao {
    public static final String fileName = "sqls/wechat.sql";

    @Override
    public CustWx findCustWxByOpenId(String openid) {
        CustWx cust = this.getDao().fetch(CustWx.class, Cnd.where("openId", "=", openid));
        return cust;
    }

    @Override
    @Transactional
    public CustWx insertCustWx(CustWx user) {
        CustWx wxUser = this.getDao().insert(user);
        return wxUser;
    }

    @Override
    public CustInfo insertCustInfo(CustInfo custInfo) {
        return this.getDao().insert(custInfo);
    }
}
