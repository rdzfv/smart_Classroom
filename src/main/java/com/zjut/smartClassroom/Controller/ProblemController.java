package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.model.MyAnswersModel;
import com.zjut.smartClassroom.model.ProblemsDetailIInProblemSetModel;
import com.zjut.smartClassroom.response.CommonReturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description： problemController
 * @version:     1.0.0
 */
@Api("problem接口")
@Controller("/problem")
@RequestMapping("/problem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemController extends BaseController {
    @Autowired
    private ProblemService problemService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description： 通过ProblemSetId获取学生答题情况（传入ProblemSetId[非空]）
     * @version:     1.0.0
     */
    @ApiOperation("通过problemSetId获取学生答题情况")
    @RequestMapping(value = "/getProblemSetStudentAnsweringDetailByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemSetStudentAnsweringDetailByProblemSetId(int problemSetId) throws BusinessException {
        // 通过problemSetId查询题目详情
        ArrayList<AnswerSituation> answerSituation = problemService.getProblemSetStudentAnsweringDetailByProblemSetId(problemSetId);
        return CommonReturnType.create(answerSituation);
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description： 通过problemId修改problem详情（传入问题id[非空]）
     * @version:     1.0.0
     */
    @ApiOperation("通过problemId修改problem详情")
    @RequestMapping(value = "/updateProblemById", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateProblem(Problem problem) throws BusinessException {
        // 入参校验
        if (!(problem.getProblemAns() == null || problem.getProblemAns() == 1 || problem.getProblemAns() == 2 ||
                problem.getProblemAns() == 3 || problem.getProblemAns() == 4 ||
                problem.getProblemAns() == 0 )
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 更新问题
        Problem problemResult = problemService.updateProblem(problem);
        return CommonReturnType.create(problemResult);
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description： 通过problemId获取problem详情（传入问题id[非空]）
     * @version:     1.0.0
     */
    @ApiOperation("通过problemId获取problem详情")
    @RequestMapping(value = "/getProblemById")
    @ResponseBody
    public CommonReturnType getProblem(int problemId) throws BusinessException {
        System.out.println(problemId);
        // 通过problemId获取问题详情
        Problem problem = problemService.getProblem(problemId);
        return CommonReturnType.create(problem);
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description： 添加problem（传入题干[非空]，正确答案[1-4]，选项1[非空]，选项2[非空]，选项3[非空]，选项4[非空]）
     * @version:     1.0.0
     */
    @ApiOperation("添加problem")
    @RequestMapping(value = "/addProblem", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addProblem(Problem problem) throws BusinessException {
        System.out.println(problem);
        // 入参校验
        if (StringUtils.isEmpty(problem.getProblemInfo()) ||
                (problem.getProblemAns() != 1 && problem.getProblemAns() != 2 && problem.getProblemAns() != 3 && problem.getProblemAns() != 4) ||
                StringUtils.isEmpty(problem.getProblemChoose1()) || StringUtils.isEmpty(problem.getProblemChoose2()) ||
                StringUtils.isEmpty(problem.getProblemChoose3()) || StringUtils.isEmpty(problem.getProblemChoose4())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 增加问题
        Problem problemResult = problemService.addProblem(problem);
        if (problemResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return CommonReturnType.create(problemResult);
    }

    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/04 22:59:23
     * @description： 通过problemset_id获取问题详情列表
     * @version:     1.0.0
     */
    @ApiOperation("通过problemset_id获取问题详情列表")
    @RequestMapping(value = "/getProblemsByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemsByProblemSetId(int id) throws BusinessException {
        // 通过problemSet_id获取问题详情列表
        ArrayList<ProblemsDetailIInProblemSetModel> problemResults = problemService.getProblemsByProblemSetId(id);
        if (problemResults == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return CommonReturnType.create(problemResults);
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/04 10:46:42
     * @description： 提交我的做题结果
     * @version:     1.0.0
     */
    @RequestMapping(value = "/postMyAnswer", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType postMyAnswer(MyAnswersModel myAnswersModel) throws BusinessException {
        // 入参校验
        if (myAnswersModel.getStudentId() == 0 || StringUtils.isEmpty(myAnswersModel.getMyAnswers()) ||
                myAnswersModel.getCourseId() == 0 || myAnswersModel.getProblemSetId() == 0
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // 通过problemSetId查询problemIdS
        ArrayList<ProblemsDetailIInProblemSetModel> problemResults = problemService.getProblemsByProblemSetId(myAnswersModel.getProblemSetId());
        if (problemResults == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);

        // 保存学生答题情况
        int myAnswersModelResult = problemService.addMyResult(myAnswersModel.getStudentId(), myAnswersModel.getCourseId(), myAnswersModel.getProblemSetId(), problemResults, myAnswersModel.getMyAnswers());
        if (myAnswersModelResult == 0) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return CommonReturnType.create(myAnswersModelResult);
    }
}
