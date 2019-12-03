package com.zjut.chocalate.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.chocalate.Service.UserService;
import com.zjut.chocalate.dataObject.MemberInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("/user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends baseController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UserLoginInfo userLoginInfoInstanse;
    @Autowired
    private MemberInfo memberInfo;

    // 用户登录接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType login(UserLoginInfo userLoginInfo) throws BusinessException {
        System.out.println(userLoginInfo.getUsername());
        // 入参校验
        if(StringUtils.isEmpty(userLoginInfo.getUsername()) || StringUtils.isEmpty(userLoginInfo.getPassword()) ||
                userLoginInfo.getType() == null || userLoginInfo.getType() == 0
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 用户登录服务（账号密码类型验证）
        userLoginInfoInstanse = userService.login(userLoginInfo);
        // 如果是会员
        if (userLoginInfoInstanse.getType() == 1) {
            memberInfo = userService.findMemberInfoById(userLoginInfoInstanse.getUserid());
            return CommonReturnType.create(memberInfo);
        }
        return CommonReturnType.create(userLoginInfoInstanse);
    }
}
