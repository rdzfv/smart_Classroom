package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.dataObject.ProblemSetPart;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller("/problemSet")
@RequestMapping("/problemSet")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemSetController extends baseController {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired
    private ProblemSetService problemSetService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/getProblemSetByCourseId")
    @ResponseBody
    public CommonReturnType getProblemsetByCourseId(@RequestParam(name = "course_id")int course_id) throws BusinessException {
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

    @RequestMapping("/getProblemSetByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemsetByProblemSetId(@RequestParam(name = "problem_set_id")int problem_set_id) throws BusinessException{
        //调用service服务获取对应的problemsetid的用户对象并返回给前端
        System.out.println("进入getProblemSetByProblemSetId接口");
        ProblemSetPart problemset_Model = problemSetService.getDataByProblemSetId(problem_set_id);
        if (problemset_Model == null){
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_NOT_EXIST);
            throw businessException;
        }
        return CommonReturnType.create(problemset_Model);
    }

    @RequestMapping(value = "/updateProblemSetByProblemSetId", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateProblemSetByProblemSetId(ProblemSetPart problemSetPart) throws BusinessException{
        //调用service服务获取对应的problemsetid的用户对象并修改对象
        System.out.println("进入updateProblemSetByProblemSetId接口");
        int flag = problemSetService.updateDataByProblemSetId(problemSetPart);
        if (flag != 1){
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_CHANGE_FAILED);
            throw  businessException;
        }
        return CommonReturnType.create(flag);
    }

    @RequestMapping("/deleteProblemSetByProblemSetId")
    @ResponseBody
    public CommonReturnType deleteProblemSetByProblemSetId(@RequestParam("problem_set_id")int id) throws BusinessException{
        int flag = problemSetService.deleteDataByProblemSetId(id);
        if (flag != 1){
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_SET_DELETE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }


    /**
     * John结束部分
     */

}
