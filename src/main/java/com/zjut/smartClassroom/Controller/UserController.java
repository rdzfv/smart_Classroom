package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller("/user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends baseController {
    // 引入
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    // 用户登录接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType login(Student student) throws BusinessException {
        System.out.println(student);
        // 入参校验
        if(StringUtils.isEmpty(student.getStudentname()) || StringUtils.isEmpty(student.getStudentaccount()) ||
                StringUtils.isEmpty(student.getStudentpassword()) || StringUtils.isEmpty(student.getOpenid()) ||
                StringUtils.isEmpty(student.getSessionkey())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 用户登录服务
        Student studentInstanse = userService.login(student);
        return CommonReturnType.create(studentInstanse);
    }

    //通过用户id获取用户信息//////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name ="id")int id) throws BusinessException{
        //调用service服务获取对应的id的用户对象并返回给前端
        System.out.println("进入get接口");
        Student userModel = userService.getUserById(id);
        if(userModel == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.USER_NOT_EXIST);
            throw businessException;
        }
        //返回通用对象
        return CommonReturnType.create(userModel);
    }
}
