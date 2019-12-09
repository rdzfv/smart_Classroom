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

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：userController
 * @version:     1.0.0
 */
@Controller("/user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends BaseController {
    // 引入
    @Autowired
    private UserService userService;
    // 引入
    @Autowired
    private HttpServletRequest httpServletRequest;


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/02 12:45:23
     * @description：用户登录接口（传入学生姓名[非空]、账户名[非空]、密码[非空]、openid[非空]、sessionkey[非空]）
     * @version:     1.0.0
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType login(Student student) throws BusinessException {
        System.out.println(student);
        // 入参校验
        if (StringUtils.isEmpty(student.getStudentName()) || StringUtils.isEmpty(student.getStudentAccount()) ||
                StringUtils.isEmpty(student.getStudentPassword()) || StringUtils.isEmpty(student.getOpenId()) ||
                StringUtils.isEmpty(student.getSessionKey())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 用户登录服务
        Student studentInstanse = userService.login(student);
        if (studentInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(studentInstanse);
    }

}
