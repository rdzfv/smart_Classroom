package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.PaperProblemService;
import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import com.zjut.smartClassroom.repository.PaperProblemRepository;
import com.zjut.smartClassroom.repository.PaperProblemViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperProblemImpl implements PaperProblemService {


    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    PaperProblemRepository paperProblemRepository;
    @Autowired(required = false)
    PaperProblemViewRepository paperProblemViewRepository;

    // 根据paperId来插入problem
    @Override
    @Transactional
    public int insertProblemByPaperId(ProblemPaper newPaperProblem) {
        paperProblemRepository.save(newPaperProblem);
        return 1;
    }

    // 根据paperId来查询试卷
    @Override
    @Transactional
    public List<PaperProblemView> getDataByPaperId(int paperId) {
        List<PaperProblemView> paperProblemViewList = paperProblemViewRepository.findAllByPaperId(paperId);
        System.out.println(paperProblemViewList);
        if (paperProblemViewList.size() != 0)
            return paperProblemViewList;
        return null;
    }

    // 根据paperId来修改试卷
    @Override
    public int updatePaperProblem(ProblemPaper newPaperProblem,int newProblemId) {
        int flag = paperProblemRepository.updatePaperProblemByPaperId(newProblemId,newPaperProblem.getPaperId(),newPaperProblem.getProblemId());
        System.out.println(flag);
        return flag;
    }

    // 根据paperId删除试卷内题目
    @Override
    public int deletePaperProblem(int paperId, int problemId) {
        int flag = paperProblemRepository.deleteProblemByPaperId(paperId,problemId);
        System.out.println(flag);
        return flag;
    }


}
