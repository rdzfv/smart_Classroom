package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.PaperProblemService;
import com.zjut.smartClassroom.dataObject.PaperProblem;
import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.repository.PaperProblemDeleteByPaperIdRepository;
import com.zjut.smartClassroom.repository.PaperProblemFindByIdRepository;
import com.zjut.smartClassroom.repository.PaperProblemInsertRepository;
import com.zjut.smartClassroom.repository.PaperProblemUpdateRepository;
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
    PaperProblemInsertRepository paperProblemInsertRepository;
    @Autowired(required = false)
    PaperProblemFindByIdRepository paperProblemFindByIdRepository;
    @Autowired(required = false)
    PaperProblemUpdateRepository paperProblemUpdateRepository;
    @Autowired(required = false)
    PaperProblemDeleteByPaperIdRepository paperProblemDeleteByPaperIdRepository;
    @Autowired(required = false)
    List<PaperProblemView> paperProblemViewList;

    // 根据paperId来插入problem
    @Override
    @Transactional
    public int insertProblemByPaperId(PaperProblem newPaperProblem) {
        paperProblemInsertRepository.save(newPaperProblem);
        return 1;
    }

    // 根据paperId来查询试卷
    @Override
    @Transactional
    public List<PaperProblemView> getDataByPaperId(int paperId) {
        paperProblemViewList = paperProblemFindByIdRepository.findAllByPaperId(paperId);
        System.out.println(paperProblemViewList);
        if (paperProblemViewList.size() != 0)
            return paperProblemViewList;
        return null;
    }

    // 根据paperId来修改试卷
    @Override
    public int updatePaperProblem(PaperProblem newPaperProblem,int newProblemId) {
        int flag = paperProblemUpdateRepository.updatePaperProblemByPaperId(newProblemId,newPaperProblem.getPaperId(),newPaperProblem.getProblemId());
        System.out.println(flag);
        return flag;
    }

    // 根据paperId删除试卷内题目
    @Override
    public int deletePaperProblem(int paperId, int problemId) {
        int flag = paperProblemDeleteByPaperIdRepository.deleteProblemByPaperId(paperId,problemId);
        System.out.println(flag);
        return flag;
    }


}
