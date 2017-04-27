package com.lcnet.lynn.dao;

import com.lcnet.lynn.model.CustInfo;
import com.lcnet.lynn.model.CustWx;

/**
 * Created by xusha on 2017/4/27.
 */
public interface WeChatDao {
    CustWx findCustWxByOpenId(String openid);

    CustWx insertCustWx(CustWx user);

    CustInfo insertCustInfo(CustInfo form);
}
