package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.StudentDO;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller("/user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends baseController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    //用户登录接口/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "userAccount") String userAccount,
                                  @RequestParam(name = "password") String password,
                                  @RequestParam(name = "name") String name,
                                  @RequestParam(name = "openId") String openId,
                                  @RequestParam(name = "sessionKey") String sessionKey
    ) throws BusinessException {
        // 入参校验
        if(StringUtils.isEmpty(userAccount) || StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(name) || StringUtils.isEmpty(openId) ||
                StringUtils.isEmpty(sessionKey)
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 参数传入DAO对象
        StudentDO studentDO = new StudentDO();
        studentDO.setStudentAccount(userAccount);
        studentDO.setStudentName(name);
        studentDO.setStudentPassword(password);
        studentDO.setOpenid(openId);
        studentDO.setSessionKey(sessionKey);
        // 用户登录服务
        StudentDO studentDOInstanse = userService.login(studentDO);
        return CommonReturnType.create(studentDO);
    }

    //通过用户id获取用户信息//////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name ="id")Integer id) throws BusinessException{
        //调用service服务获取对应的id的用户对象并返回给前端
        System.out.println("进入get接口");
        System.out.println(userService);
        StudentDO userModel=userService.getUserById(id);
        if(userModel == null){
            BusinessException businessException = new BusinessException(EnumBusinessError.USER_NOT_EXIST);
            throw businessException;
        }
        //返回通用对象
        return CommonReturnType.create(userModel);
    }
}
