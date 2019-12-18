package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import com.zjut.smartClassroom.view.StudentCourseDetailView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Controller
 * @ClassName: CourseController
 * @Author: FrankWu
 * @Description: 添加、修改课程信息等
 * @Date: 2019/12/7 09:08
 * @Version: 1.0
 */
@Api("课程接口")
@Controller("/course")
@RequestMapping("/course")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class CourseController extends BaseController {
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
    @ApiOperation("更新course")
    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType updateCourse(@RequestBody() Course course) throws BusinessException {
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
    @ApiOperation("为course添加problemSet")
    @RequestMapping(value = "/addProblemSetToCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType addProblemSetToCourse(@RequestBody() ProblemSet problemSet) throws BusinessException {
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
    @ApiOperation("为course添加PPT")
    @RequestMapping(value = "/addPPT_ToCourse", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType addPPT_ToCourse(@RequestBody() CoursePPT coursePPT) throws BusinessException {
        // 输出参数的校验
        Integer courseId = coursePPT.getCourseId();
        String ppt_url = coursePPT.getPpt_url();
        Integer teacherId = coursePPT.getTeacherId();
        if (courseId == null || teacherId == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_IS_NULL);
        } else if (courseId < 0 || teacherId < 0) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        } else if (ppt_url == null) {
            throw new BusinessException(EnumBusinessError.PPT_URL_IS_NULL);
        }
        // 检验：寻找的id号是否存在，若不存在则会报错
        courseService.findCourseById(courseId);
        userService.findTeacherById(teacherId);
        CoursePPT coursePPT1 = coursePPTService.addCoursePPT(coursePPT);
        return CommonReturnType.create(coursePPT1);
    }
  
    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/18
     * @description： 通过courseId查询全部ppt
     * @version:     1.0.0
     */
    @ApiOperation("通过courseId查询全部ppt")
    @RequestMapping(value = "/getPPTsByCourseId", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType getPPTsByCourseId(int courseId) throws BusinessException {
        // 通过courseId查询全部ppt
        ArrayList<CoursePPT> coursePPTs = coursePPTService.findPPTsByCourseId(courseId);
        return CommonReturnType.create(coursePPTs);
    }
}
