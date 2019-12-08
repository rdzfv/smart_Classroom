package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Answer;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.model.MyAnswersModel;
import com.zjut.smartClassroom.model.ProblemsDetailIInProblemSetModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemService接口
 * @version:     1.0.0
 */
@Service
public interface ProblemService {
    // 通过problemId获取答题情况
    ArrayList<AnswerSituation> getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException;
    // 添加问题
    Problem addProblem(Problem problem) throws BusinessException;
    // 通过id更新问题
    Problem updateProblem(Problem problem) throws BusinessException;
    // 根据id获取问题
    Problem getProblem(int problemId) throws BusinessException;
    // 通过problemSet_id获取问题详情列表
    ArrayList<ProblemsDetailIInProblemSetModel> getProblemsByProblemSetId(int problemSetId) throws BusinessException;
    // 保存做题记录
    int addMyResult(int studentId, int courseId, int problemSetId, ArrayList<ProblemsDetailIInProblemSetModel> problemResults, String myAnsList) throws BusinessException ;

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有题目
    List<Problem> getAllData();
}
