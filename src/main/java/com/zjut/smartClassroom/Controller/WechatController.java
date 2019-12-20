package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import com.zjut.smartClassroom.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.zjut.smartClassroom.Service.HttpClient;

import javax.servlet.http.HttpServletRequest;


/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/21 01:28
 * @description： wechatController
 * @version:     1.0.0
 */

@Api("微信模快")
@Controller("/wechat")
@RequestMapping("/wechat")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class WechatController extends BaseController {
    // 引入
    @Autowired
    private UserService userService;
    // 引入
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpClient httpClient;



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 01:28
     * @description： 请求校验接口
     * @version:     1.0.0
     */
    @ApiOperation("请求校验接口")
    @RequestMapping(value = "/ckeckRequest", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType ckeckRequest(String openId, String formId) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(openId) || StringUtils.isEmpty(formId)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
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
        return CommonReturnType.create(access_token);
    }


//    /**
//     * @author     ：xyy
//     * @date       ：Created in 2019/12/21 03:10
//     * @description： 请求校验接口
//     * @version:     1.0.0
//     */
//    @ApiOperation("通过code获取openid和sessionkey")
//    @RequestMapping(value = "/getOpenIdAndSessionKey", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonReturnType cgetOpenIdAndSessionKey(String code) throws BusinessException {
//        // 入参校验
//        if (StringUtils.isEmpty(code)) {
//            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
//        // 发送http请求到微信平台
//        // String url = "https://www.xuyuyan.cn/course/getPPTsByCourseId?courseId=1";
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxe0e7b169cc15bae7&&secret=f1b095f7429a158469e3eee246eed1db&&js_code=" + code + "&grant_type=authorization_code";
//        //post请求
//        HttpMethod method = HttpMethod.GET;
//        // 发送http请求并返回结果
//        String wechatResult = httpClient.client_GET(url,method);
//        System.out.println(wechatResult);
//        // string结果转为json并获取access_token
//        Utils utils = new Utils();
//        JSONObject wechatReturnJSON = utils.String2Json(wechatResult);
//        if (wechatReturnJSON.get("openid") == null || wechatReturnJSON.get("session_key") == null) throw new BusinessException(EnumBusinessError.ILLEGAL_REQUEST);
//        String openid = wechatReturnJSON.get("openid").toString();
//        String session_key = wechatReturnJSON.get("session_key").toString();
//        System.out.println("access_token" + access_token);
//        return CommonReturnType.create(wechatResult);
//    }
}
