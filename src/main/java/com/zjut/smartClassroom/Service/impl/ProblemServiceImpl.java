package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.ProblemRepository;
import com.zjut.smartClassroom.repository.AnswerSituationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemService接口的实现类
 * @version:     1.0.0
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired(required = false)//引入
    private AnswerSituationRepository answerSituationRepository;
    @Autowired(required = false)//引入
    private AnswerSituation answerSituation;
    @Autowired(required = false)//引入
    private ProblemRepository problemRepository;

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：根据problemsetId获取学生答题情况详情
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public AnswerSituation getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException {
        answerSituation= answerSituationRepository.findByProblemId(problemId);
        System.out.println(answerSituation);
        return  answerSituation;
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：修改问题
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem updateProblem(Problem problem) throws BusinessException {
        // 数据库查出待更新对象
        Problem problemFindingResult = problemRepository.findByProblemId(problem.getProblemId());
        if (problemFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(problem, problemFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Problem problemResult = problemRepository.save(problemFindingResult);
        if (problemResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problemResult;
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：根据problemId获取问题详情
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem getProblem(int problemId) throws BusinessException {
        Problem problem = problemRepository.findByProblemId(problemId);
        if (problem == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problem;
    }

    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：添加问题（传入problem对象）
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem addProblem(Problem problem) throws BusinessException {
        Problem success= problemRepository.save(problem);
        return success;
    }

}
