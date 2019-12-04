package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.ProblemAddRepository;
import com.zjut.smartClassroom.repository.ProblemRepository;
import com.zjut.smartClassroom.repository.ProblemUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired(required = false)//引入
    private ProblemRepository problemRepository;
    @Autowired(required = false)//引入
    private AnswerSituation answerSituation;
    @Autowired(required = false)//引入
    private ProblemUpdateRepository problemUpdateRepository;
    @Autowired(required = false)//引入
    private ProblemAddRepository problemAddRepository;

    @Override
    @Transactional
    public AnswerSituation getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException {
        answerSituation=problemRepository.findByProblemId(problemId);
        System.out.println(answerSituation);
        return  answerSituation;
    }

    @Override
    @Transactional
    public Problem updateProblem(Problem problem) throws BusinessException {
        // 数据库查出待更新对象
        Problem problemFindingResult = problemUpdateRepository.findAllByProblemId(problem.getProblemId());
        if (problemFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(problem, problemFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Problem problemResult = problemUpdateRepository.save(problemFindingResult);
        if (problemResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problemResult;
    }

    @Override
    @Transactional
    public Problem getProblem(int problemId) throws BusinessException {
        Problem problem = problemUpdateRepository.findAllByProblemId(problemId);
        if (problem == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problem;
    }

    @Override
    @Transactional
    public Problem addProblem(Problem problem) throws BusinessException {
        Problem success=problemAddRepository.save(problem);
        return success;
    }

}
