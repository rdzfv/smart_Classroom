package com.zjut.smartClassroom.Controller;


import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.StudentService;
import com.zjut.smartClassroom.dataObject.Student;
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
 * @author: Hefz.
 * @date: 2019/12/18.
 * @description:
 */

@Api("学生模块")
@Controller("/student")
@RequestMapping("/student")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @ApiOperation("通过学生id获得学生信息")
    @RequestMapping(value = "/findStudentByStudentId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType findStudentByStudentId(int studentId) throws BusinessException {
        Student student = studentService.findStudentByStudentId(studentId);
        return CommonReturnType.create(student);
    }
}
