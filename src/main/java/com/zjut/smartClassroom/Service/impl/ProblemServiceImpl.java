package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired(required = false)//引入
    private ProblemRepository problemRepository;
    @Autowired(required = false)//引入
    private AnswerSituation answerSituation;

    @Override
    @Transactional
    public AnswerSituation getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) {
        answerSituation=problemRepository.findByProblemId(problemId);
        System.out.println(answerSituation);
        return  answerSituation;
    }
}
