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

}
