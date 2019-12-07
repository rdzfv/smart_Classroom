package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperProblemService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 根据paperId与problemId插入题目
    int insertProblemByPaperId(ProblemPaper newPaperProblem);
    // 根据paperId查询出试卷的所有相关信息
    List<PaperProblemView> getDataByPaperId(int paperId);
    // 根据paperId修改试卷的相关信息
    int updatePaperProblem(ProblemPaper newPaperProblem,int newProblemId);
    // 根据paperId删除试卷内题目
    int deletePaperProblem(int paperId,int problemId);
}