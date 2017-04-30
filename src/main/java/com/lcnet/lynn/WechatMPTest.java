package com.lcnet.lynn;
/*package com.lcnetwork;*/
import java.io.InputStream;

import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

public class WechatMPTest {

	public static void main(String[] args) {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx77d473956373ecb2"); // 设置微信公众号的appid
		config.setSecret("09af0dbc5c2f695a5731d6e9f67ae9e5"); // 设置微信公众号的app corpSecret
		
		WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        
        try {
			wxService.menuDelete();
			InputStream menuIs = WechatMPTest.class.getResourceAsStream("/wechat_mp_menu.json");
	        WxMenu wxMenu = WxMenu.fromJson(menuIs);
	        wxService.menuCreate(wxMenu);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
}
