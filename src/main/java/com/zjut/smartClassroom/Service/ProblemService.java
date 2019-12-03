package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.stereotype.Service;

@Service
public interface ProblemService {
    //通过problemId获取答题情况
    AnswerSituation getProblemSetStudentAnsweringDetailByProblemSetId(int problemId);

}
