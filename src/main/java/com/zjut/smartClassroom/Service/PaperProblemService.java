package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperProblemService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 根据paperId与problemId插入题目
    int insertProblemByPaperId(ProblemPaper newPaperProblem) throws BusinessException;
    // 根据paperId查询出试卷的所有相关信息
    List<PaperProblemView> getDataByPaperId(int paperId) throws BusinessException ;
    // 根据paperId修改试卷的相关信息
    Paper updatePaper(Paper paper) throws BusinessException ;
    // 根据paperId删除试卷内题目
    int deletePaperProblem(int paperId, int problemId) throws BusinessException;
    // 创建新的paper
    int createNewPaper(String proListStr, String paperName) throws BusinessException;
    // 根据paperId修改试卷的相关信息
    int updatePaperProblem(ProblemPaper newPaperProblem, int newProblemId) throws BusinessException;
}
