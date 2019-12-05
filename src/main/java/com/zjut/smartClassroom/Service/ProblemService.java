package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemService接口
 * @version:     1.0.0
 */
@Service
public interface ProblemService {
    // 通过problemId获取答题情况
    AnswerSituation getProblemSetStudentAnsweringDetailByProblemSetId(int problemId) throws BusinessException;
    // 添加问题
    Problem addProblem(Problem problem) throws BusinessException;
    // 通过id更新问题
    Problem updateProblem(Problem problem) throws BusinessException;
    // 根据id获取问题
    Problem getProblem(int problemId) throws BusinessException;
    // 通过problemSet_id获取问题详情列表
    List<Problem> getProblemsByProblemSetId(int problemSetId) throws BusinessException;
}
