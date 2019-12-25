package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.HttpClient;
import com.zjut.smartClassroom.Service.WechatService;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.utils.Utils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class WechatServiceImpl implements WechatService {

    @Autowired(required = false)
    private HttpClient httpClient;

    @Override
    public String checkRequect(String openId, String formId) throws BusinessException{
        // 发送http请求到微信平台
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc80f6fe4d1258003&secret=77e61076f62a3bac86263af8d340905f";
        //post请求
        HttpMethod method = HttpMethod.POST;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("openId", openId);
        params.add("formId", formId);
        // 发送http请求并返回结果
        String wechatResult = httpClient.client_POST(url,method,params);
        System.out.println(wechatResult);
        // string结果转为json并获取access_token
        Utils utils = new Utils();
        JSONObject wechatReturnJSON = utils.String2Json(wechatResult);
        if (wechatReturnJSON.get("access_token") == null) throw new BusinessException(EnumBusinessError.ILLEGAL_REQUEST);
        String access_token = wechatReturnJSON.get("access_token").toString();
        System.out.println("access_token" + access_token);
        return access_token;
    }

}
