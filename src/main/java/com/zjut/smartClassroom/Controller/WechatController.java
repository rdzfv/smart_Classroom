package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.Service.WechatService;
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
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private WechatService wechatService;
    @Autowired(required = false)
    private HttpServletRequest httpServletRequest;




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
        String access_token  = wechatService.checkRequect(openId, formId);
        return CommonReturnType.create(access_token);
    }
}
