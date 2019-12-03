package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemAddService;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.repository.ProblemAddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemAddServiceImpl implements ProblemAddService {
    @Autowired(required = false)//引入
    private ProblemAddRepository problemAddRepository;
    @Autowired(required = false)//引入
    private Problem problem;

    @Override
    @Transactional
    public Problem addProblem(Problem problem) {
        Problem success=problemAddRepository.save(problem);
        return success;
    }
}
