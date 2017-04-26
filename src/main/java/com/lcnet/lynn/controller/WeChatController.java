package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.CustWx;
import com.lcnet.lynn.service.WeChatService;
import com.lcnet.lynn.utils.StringUtil;
import com.lcnet.lynn.utils.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xusha on 2017/4/27.
 */
@RestController
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 获取用户openId
     * @param code
     * @return
     */
    @RequestMapping(value = "/getuseropenid", method = RequestMethod.GET)
    public Map<String, Object> getUserOpenId(@RequestParam(value = "code", required=false) String code) {
        Map<String, Object> rtn = new HashMap<>();
        if(!StringUtil.isEmpty(code)) {
            WxMpUser wxUser = WeiXinUtil.getInstant().getWxMpUser(code);
            if(wxUser != null) {
                String openid = wxUser.getOpenId();
                if(!StringUtil.isEmpty(openid)) {
                    rtn.put("openid", openid);

                    CustWx user = weChatService.findCustWxByOpenId(openid);
                    if(user == null) {
                        user = new CustWx();
                        user.setOpenId(openid);
                        /*user.setNickname(wxUser.getNickname());
                        user.setPhoto(wxUser.getHeadImgUrl());*/
                        try {
                            user = weChatService.insertCustWx(user);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return rtn;
    }
}
