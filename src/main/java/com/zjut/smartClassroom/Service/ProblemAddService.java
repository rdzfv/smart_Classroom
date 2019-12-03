package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.stereotype.Service;

@Service
public interface ProblemAddService {
    Problem addProblem(Problem problem);
}
