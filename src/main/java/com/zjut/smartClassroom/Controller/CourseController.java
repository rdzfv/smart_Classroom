package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.dataObject.ProblemSet;
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
import java.sql.Timestamp;
import java.util.Date;

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
    private PaperService paperService;
    @Autowired
    private ProblemSetService problemSetService;
    @Autowired
    private UserService userService;
    @Autowired
    private CoursePPTService coursePPTService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @Method updateCourse
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
    public CommonReturnType updateCourse(Course course) throws BusinessException {
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

    /**
     * @Method addProblemSetToCourse
     * @Author FrankWu
     * @Version 1.0
     * @Description 根据前端传输过来的problemSet对象中teacherId、courseId、paperId进行发布练习
     * @Return com.zjut.smartClassroom.response.CommonReturnType
     * @Exception
     * @Date 2019/12/7
     * @Time 14:35
     */
    @RequestMapping(value = "/addProblemSetToCourse", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addProblemSetToCourse(ProblemSet problemSet) throws BusinessException {
        // 检验：输入数值上是否错误
        Integer teacherId = problemSet.getTeacherId();
        Integer courseId = problemSet.getCourseId();
        Integer paperId = problemSet.getPaperId();
        if (teacherId == null || courseId == null || paperId == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_IS_NULL);
        } else if (courseId < 0 || paperId < 0) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 检验：寻找的id号是否存在，若不存在则会报错
        courseService.findCourseById(courseId);
        paperService.findPaperById(paperId);
        userService.findTeacherById(teacherId);

        // 自动生成时间戳
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp timestamp = new Timestamp(date.getTime());
        problemSet.setProblemReleaseTime(timestamp);
        // 若都存在，则生成练习并发布
        ProblemSet problemSetResult = problemSetService.addProblemSet(problemSet);
        return CommonReturnType.create(problemSetResult);
    }

    /**
     * @Method addPPT_ToCourse
     * @Author FrankWu
     * @Version 1.0
     * @Description 根据前端传输过来的CoursePPT对象中courseId、ppt的url进行上传ppt
     * @Return com.zjut.smartClassroom.response.CommonReturnType
     * @Exception
     * @Date 2019/12/7
     * @Time 16:31
     */
    @RequestMapping(value = "/addPPT_ToCourse", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addPPT_ToCourse(CoursePPT coursePPT) throws BusinessException {
        // 输出参数的校验
        Integer courseId = coursePPT.getCourseId();
        String ppt_url = coursePPT.getPpt_url();
        if (courseId == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_IS_NULL);
        } else if (courseId < 0) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        } else if (ppt_url == null) {
            throw new BusinessException(EnumBusinessError.PPT_URL_IS_NULL);
        }
        // 检验：寻找的id号是否存在，若不存在则会报错
        courseService.findCourseById(courseId);
        CoursePPT coursePPT1 = coursePPTService.addCoursePPT(coursePPT);
        return CommonReturnType.create(coursePPT1);
    }


}
