package com.lcnet.lynn.utils;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * Created by lynn on 2017/4/27.
 */
public class WeiXinUtil {

    private static WeiXinUtil weiXinUtil;
    private static WxMpService wxMpService;
    private static String TOKEN = "CalSysTokenInfo";

    private static String APPID = "wx77d473956373ecb2";

    private static String APPSECRET = "09af0dbc5c2f695a5731d6e9f67ae9e5";

    private static String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=URL&response_type=code&scope=snsapi_userinfo&state=PARAM#wechat_redirect";

    private static String APPLY_URL = "http://gplynn.ngrok.cc/wechat/";

    public static WeiXinUtil getInstant() {
        if (weiXinUtil == null) {
            weiXinUtil = getWeiXinUtil();
        }
        return weiXinUtil;
    }

    private static WeiXinUtil getWeiXinUtil() {
        weiXinUtil = new WeiXinUtil();
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(APPID);
        config.setSecret(APPSECRET);

        // TODO: 2017/4/27 不懂啊
        config.setPartnerId("123456");
        config.setPartnerKey("LynnLynn");

        config.setToken(TOKEN);
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(config);
        return weiXinUtil;
    }

    public WxMpUser getWxMpUser(String oauth2Code) {
        if (StringUtil.isEmpty(oauth2Code)) {
            return null;
        }
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(oauth2Code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            return wxMpUser;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
