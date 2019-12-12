package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller("/problemSet")
@RequestMapping("/problemSet")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemSetController extends BaseController {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired
    private ProblemSetService problemSetService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @ApiOperation("通过courseId获取problemSet")
    @RequestMapping(value = "/getProblemSetByCourseId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getProblemsetByCourseId(@RequestParam(name = "course_id") int course_id) throws BusinessException {
        //调用service服务获取对应的courseid的用户对象并返回给前端
        System.out.println("进入getProblemSetByCourseId接口");
        ProblemSetCourse problemset_Model = problemSetService.getDataByCourseId(course_id);
        if(problemset_Model == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_NOT_EXIST);
            throw businessException;
        }
        //返回通用对象
        return CommonReturnType.create(problemset_Model);
    }

    @ApiOperation("通过problemSetId获取problemSet")
    @RequestMapping(value = "/getProblemSetByProblemSetId" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getProblemsetByProblemSetId(@RequestParam(name = "problem_set_id") int problem_set_id) throws BusinessException{
        //调用service服务获取对应的problemsetid的用户对象并返回给前端
        System.out.println("进入getProblemSetByProblemSetId接口");
        ProblemSet problemset_Model = problemSetService.getDataByProblemSetId(problem_set_id);
        if (problemset_Model == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_NOT_EXIST);
            throw businessException;
        }
        return CommonReturnType.create(problemset_Model);
    }

    @ApiOperation("通过problemSetId更新problemSet")
    @RequestMapping(value = "/updateProblemSetByProblemSetId", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType updateProblemSetByProblemSetId(@RequestBody() ProblemSet problemSetPart) throws BusinessException {
        //调用service服务获取对应的problemsetid的用户对象并修改对象
        System.out.println("进入updateProblemSetByProblemSetId接口");
        ProblemSet problemSetResult = problemSetService.updateDataByProblemSetId(problemSetPart);
        if (problemSetResult == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_CHANGE_FAILED);
            throw  businessException;
        }
        return CommonReturnType.create(problemSetResult);
    }

    @ApiOperation("通过problemSetId删除problemSet")
    @RequestMapping(value = "/deleteProblemSetByProblemSetId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType deleteProblemSetByProblemSetId(@RequestParam("problem_set_id") int id) throws BusinessException{
        int flag = problemSetService.deleteDataByProblemSetId(id);
        if (flag != 1) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_DELETE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }


    /**
     * John结束部分
     */
    @ApiOperation("通过teacher_id获取练习集")
    @RequestMapping(value = "/getProblemSetByTeacherId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType findByteacherId(int teacherId) throws BusinessException {
        // 通过teacher_id获取问题详情列表
        ArrayList<ProblemSet> courseList = problemSetService.findByteacherId(teacherId);
        return CommonReturnType.create(courseList);
    }


}
