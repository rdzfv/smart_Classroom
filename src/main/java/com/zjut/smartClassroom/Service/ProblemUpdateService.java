package com.zjut.smartClassroom.Service;


import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.stereotype.Service;

@Service
public interface ProblemUpdateService {
    int updateProblem(Problem problem);
    Problem getProblem(int problemId);
}
