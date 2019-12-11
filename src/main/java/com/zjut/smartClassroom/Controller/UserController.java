package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("用户模块")
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
    @ApiOperation("学生登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType login(@RequestBody() Student student) throws BusinessException {
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

    /**
     * @Method login
     * @Author Hefz
     * @Version  1.0
     * @Description
     * @Return com.zjut.smartClassroom.response.CommonReturnType
     * @Exception
     * @Date 2019/12/11
     * @Time 11:37 PM
     */
    @ApiOperation("教师登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType login(@RequestBody() Teacher teacher) throws BusinessException {
        System.out.println(teacher);
        // 入参校验
        if (StringUtils.isEmpty(teacher.getTeacherName()) || StringUtils.isEmpty(teacher.getTeacherAccount()) ||
                StringUtils.isEmpty(teacher.getTeacherPassword()) || StringUtils.isEmpty(teacher.getOpenid()) ||
                StringUtils.isEmpty(teacher.getSessionKey())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 用户登录服务
        Teacher teacherInstanse = userService.login(teacher);
        if (teacherInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(teacherInstanse);
    }

}
