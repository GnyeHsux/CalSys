package com.lcnet.lynn.service;

import com.lcnet.lynn.model.CustInfo;
import com.lcnet.lynn.model.CustWx;
import com.lcnet.lynn.model.vo.RegisterForm;

/**
 * Created by lynn on 2017/4/27.
 */
public interface WeChatService {
    CustWx findCustWxByOpenId(String openid);

    CustWx insertCustWx(CustWx user) throws Exception;

    CustInfo insertCustInfo(RegisterForm form);
}
