package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ProblemAddService;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.Service.ProblemUpdateService;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.Student;
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

@Controller("/problem")
@RequestMapping("/problem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemController extends baseController{
    @Autowired
    private ProblemService problemService;
    @Autowired
    private ProblemUpdateService problemUpdateService;
    @Autowired
    private ProblemAddService problemAddService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/getProblemSetStudentAnsweringDetailByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException {
        System.out.println(problemId);

        // 用户登录服务
        AnswerSituation answerSituation = problemService.getProblemSetStudentAnsweringDetailByProblemSetId(problemId);
        return CommonReturnType.create(answerSituation);
    }

    @RequestMapping(value = "/updateProblemById", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateProblem(Problem problem) throws BusinessException {
        System.out.println(problem);
//        // 入参校验
//        if(StringUtils.isEmpty(student.getStudentname()) || StringUtils.isEmpty(student.getStudentaccount()) ||
//                StringUtils.isEmpty(student.getStudentpassword()) || StringUtils.isEmpty(student.getOpenid()) ||
//                StringUtils.isEmpty(student.getSessionkey())
//        ) {
//            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
        // 更新问题
        int success= problemUpdateService.updateProblem(problem);
        return CommonReturnType.create(success);
    }

    @RequestMapping(value = "/updateProblemById")
    @ResponseBody
    public CommonReturnType getProblem(int problemId) throws BusinessException {
        System.out.println(problemId);

        // 通过problemId获取问题详情
        Problem problem=problemUpdateService.getProblem(problemId);
        return CommonReturnType.create(problem);
    }

    @RequestMapping(value = "/addProblem", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addProblem(Problem problem) throws BusinessException {
        System.out.println(problem);
//        // 入参校验
//        if(StringUtils.isEmpty(student.getStudentname()) || StringUtils.isEmpty(student.getStudentaccount()) ||
//                StringUtils.isEmpty(student.getStudentpassword()) || StringUtils.isEmpty(student.getOpenid()) ||
//                StringUtils.isEmpty(student.getSessionkey())
//        ) {
//            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
        // 增加问题
        Problem success= problemAddService.addProblem(problem);
        if(success!=null){
            return CommonReturnType.create(1);
        }else
            return CommonReturnType.create(0);

    }
}
