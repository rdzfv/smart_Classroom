package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
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
import java.util.List;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：problemController
 * @version:     1.0.0
 */
@Controller("/problem")
@RequestMapping("/problem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemController extends baseController{
    @Autowired
    private ProblemService problemService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：通过练习id获取学生答题情况（传入练习id[非空]）
     * @version:     1.0.0
     */
    @RequestMapping(value = "/getProblemSetStudentAnsweringDetailByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException {
        // 通过problemId查询题目详情
        AnswerSituation answerSituation = problemService.getProblemSetStudentAnsweringDetailByProblemSetId(problemId);
        return CommonReturnType.create(answerSituation);
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：通过problemId修改problem详情（传入问题id[非空]）
     * @version:     1.0.0
     */
    @RequestMapping(value = "/updateProblemById", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateProblem(Problem problem) throws BusinessException {
        System.out.println(problem.getProblemAns());
        // 入参校验
        if (!(problem.getProblemAns() == 1 || problem.getProblemAns() == 2 ||
                problem.getProblemAns() == 3 || problem.getProblemAns() == 4 ||
                problem.getProblemAns() == 0)
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
     * @description：通过problemId获取problem详情（传入问题id[非空]）
     * @version:     1.0.0
     */
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
     * @description：添加problem（传入题干[非空]，正确答案[1-4]，选项1[非空]，选项2[非空]，选项3[非空]，选项4[非空]）
     * @version:     1.0.0
     */
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
     * @description：通过priblemset_id获取问题详情列表
     * @version:     1.0.0
     */
    @RequestMapping(value = "/getProblemsByProblemSetId")
    @ResponseBody
    public CommonReturnType getProblemsByProblemSetId(int id) throws BusinessException {
        // 通过problemSet_id获取问题详情列表
        List<Problem> problemResults = problemService.getProblemsByProblemSetId(id);
        if (problemResults == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return CommonReturnType.create(problemResults);
    }
}