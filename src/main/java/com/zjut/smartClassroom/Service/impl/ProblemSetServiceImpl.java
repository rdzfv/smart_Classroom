package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemSetServiceImpl implements ProblemSetService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private ProblemSetCourseRepository problemSetCourseRepository;
    @Autowired(required = false)
    private ProblemSetRepository problemSetRepository;

    @Override
    @Transactional
    public ProblemSetCourse getDataByCourseId(int id) {
        ProblemSetCourse problemSetCourse = problemSetCourseRepository.findByCourseId(id);
        System.out.println(problemSetCourse);
        return problemSetCourse;
    }

    @Override
    @Transactional
    public ProblemSet getDataByProblemSetId(int id) {
        ProblemSet problemSet = problemSetRepository.findByProblemSetId(id);
        System.out.println(problemSet);
        return problemSet;
    }

    @Override
    public int updateDataByProblemSetId(ProblemSet problemSetPart) {
        int flag = problemSetRepository.updateDataByProblemSetId(problemSetPart.getProblemSetName(), problemSetPart.getProblemSetDetail(), problemSetPart.getProblemReleaseTime(), problemSetPart.getProblemSetPicUrl(), problemSetPart.getPaperId(), problemSetPart.getProblemSetId());
        System.out.println(flag);
        return flag;
    }

    @Override
    @Transactional
    public int deleteDataByProblemSetId(int id) {
        int flag = problemSetRepository.deleteByProblemSetId(id);
        System.out.println(flag);
        return flag;
    }
}
