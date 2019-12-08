package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.List;

/**
 * @author: Hefz.
 * @date: 2019/12/5.
 * @description:
 */

@Controller("/course")
@RequestMapping("/course")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * @author: Hefz.
     * @date: 2019/12/5.
     * @description: add course all non-null
     */

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addCourse(Course course) throws BusinessException {
        System.out.println(course);
        // 入参校验
        if(StringUtils.isEmpty(course.getCourseName())){
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 增加课程
        Course courseResult = courseService.addCourse(course);
        if (courseResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return CommonReturnType.create(course);
    }
}
