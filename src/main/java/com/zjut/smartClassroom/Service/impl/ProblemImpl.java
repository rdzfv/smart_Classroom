package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.repository.ProblemAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProblemImpl implements ProblemService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private List<Problem> problemList;
    @Autowired(required = false)
    private ProblemAllRepository problemAllRepository;

    @Override
    @Transactional
    public List<Problem> getAllData() {
        problemList = problemAllRepository.findAll();
        System.out.println(problemList);
        if (problemList.size() != 0)
            return problemList;
        return null;
    }
}
