package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemUpdateService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.repository.ProblemRepository;
import com.zjut.smartClassroom.repository.ProblemUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemUpdateServiceImpl implements ProblemUpdateService{
    @Autowired(required = false)//引入
    private ProblemUpdateRepository problemUpdateRepository;
    @Autowired(required = false)//引入
    private Problem problem;

    @Override
    @Transactional
    public int updateProblem(Problem problem) {
        int success=problemUpdateRepository.update(problem.getProblemInfo(),problem.getProblemAns(),problem.getProblemChoose1(),problem.getProblemChoose2(),problem.getProblemChoose3(),problem.getProblemChoose4(),problem.getProblemExplain(),problem.getProblemId());
        return success;
    }
    @Override
    @Transactional
    public Problem getProblem(int problemId){
        problem=problemUpdateRepository.findAllByProblemId(problemId);
        System.out.println(problem);
        return problem;
    }

}
