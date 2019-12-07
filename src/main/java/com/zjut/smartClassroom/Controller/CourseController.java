package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Controller
 * @ClassName: CourseController
 * @Author: FrankWu
 * @Description: 添加、修改课程信息等
 * @Date: 2019/12/7 09:08
 * @Version: 1.0
 */

@Controller("/course")
@RequestMapping("/course")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class CourseController extends baseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @Method updateProblem
     * @Author FrankWu
     * @Version 1.0
     * @Description 通过courseId修改course详情（传入课程id[非空且大于0]）
     * @Return com.zjut.smartClassroom.response.CommonReturnType
     * @Exception BusinessException
     * @Date 2019/12/7
     * @Time 09:35
     */
    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateProblem(Course course) throws BusinessException {
        // 入参校验
        if (course == null || course.getCourseId() == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_IS_NULL);
        } else if (course.getCourseId() < 0) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 更新课程信息
        Course courseResult = courseService.updateCourse(course);
        return CommonReturnType.create(courseResult);
    }
}
