package com.lcnet.lynn.controller;

import com.lcnet.lynn.model.CustInfo;
import com.lcnet.lynn.model.CustWx;
import com.lcnet.lynn.model.vo.RegisterForm;
import com.lcnet.lynn.service.WeChatService;
import com.lcnet.lynn.utils.StringUtil;
import com.lcnet.lynn.utils.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xusha on 2017/4/27.
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 获取用户openId
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/getuseropenid", method = RequestMethod.GET)
    public Map<String, Object> getUserOpenId(@RequestParam(value = "code", required = false) String code) {
        Map<String, Object> rtn = new HashMap<>();
        if (!StringUtil.isEmpty(code)) {
            WxMpUser wxUser = WeiXinUtil.getInstant().getWxMpUser(code);
            if (wxUser != null) {
                String openid = wxUser.getOpenId();
                if (!StringUtil.isEmpty(openid)) {
                    rtn.put("openid", openid);
                    CustWx user = weChatService.findCustWxByOpenId(openid);
                    if (user == null) {
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

    @RequestMapping("/userRegister")
    public Map<String, Object> userRegister(@ModelAttribute RegisterForm form) {
        Map<String, Object> rst = new HashMap<>();
        int errorCode = 0;
        String errorMsg = "";
        if (StringUtil.isEmpty(form.getvCode())) {
            errorCode = 1;
            errorMsg = "验证码不能为空！";
        } else {
            if (!"0000".equals(form.getvCode())) {
                errorCode = 1;
                errorMsg = "验证码不正确！";
            } else {
                //插入用户信息
                CustInfo custInfo = weChatService.insertCustInfo(form);
                if (custInfo != null) {
                    errorCode = 2;
                    errorMsg = "注册成功！";
                }
            }
        }
        rst.put("errorCode", errorCode);
        rst.put("errorMsg", errorMsg);
        return rst;
    }
}
