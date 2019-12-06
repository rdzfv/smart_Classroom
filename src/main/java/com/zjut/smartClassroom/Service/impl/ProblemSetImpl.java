package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.dataObject.ProblemSetPart;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemSetImpl implements ProblemSetService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private ProblemSetCourseRepository problemSetCourseRepository;
    @Autowired(required = false)
    private ProblemSetCourse problemSetCourse;
    @Autowired(required = false)
    private ProblemSetPartRepository problemSetPartRepository;
    @Autowired(required = false)
    private ProblemSetPartUpdateRepository problemSetPartUpdateRepository;
    @Autowired(required = false)
    private ProblemSetDeleteRepository problemSetDeleteRepository;
    @Autowired(required = false)
    private ProblemSetPart problemSetPart;

    @Override
    @Transactional
    public ProblemSetCourse getDataByCourseId(int id) {
        problemSetCourse = problemSetCourseRepository.findByCourseId(id);
        System.out.println(problemSetCourse);
        return problemSetCourse;
    }

    @Override
    @Transactional
    public ProblemSetPart getDataByProblemSetId(int id) {
        problemSetPart = problemSetPartRepository.findByProblemSetId(id);
        System.out.println(problemSetPart);
        return problemSetPart;
    }

    @Override
    public int updateDataByProblemSetId(ProblemSetPart problemSetPart) {
        int flag = problemSetPartUpdateRepository.updateDataByProblemSetId(problemSetPart.getProblemSetName(), problemSetPart.getProblemSetDetail(), problemSetPart.getProblemReleaseTime(), problemSetPart.getProblemSetPicUrl(), problemSetPart.getPaperId(), problemSetPart.getProblemSetId());
        System.out.println(flag);
        return flag;
    }

    @Override
    @Transactional
    public int deleteDataByProblemSetId(int id) {
        int flag = problemSetDeleteRepository.deleteByProblemSetId(id);
        System.out.println(flag);
        return flag;
    }


}
