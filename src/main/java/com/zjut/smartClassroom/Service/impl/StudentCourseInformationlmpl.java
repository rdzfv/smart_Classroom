package com.zjut.smartClassroom.Service.impl;
import com.zjut.smartClassroom.Service.StudentCourseInformationService;
import com.zjut.smartClassroom.dataObject.StudentCourseInformation;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */

@Service
public class StudentCourseInformationlmpl implements StudentCourseInformationService{
    @Autowired(required = false)
    private StudentCourseInformationRepository studentCourseInformationRepository;

    @Override
    @Transactional
    public ArrayList<StudentCourseInformation> findBystudentId(int studentId) throws BusinessException{
        ArrayList<StudentCourseInformation> courseList = new ArrayList<>();

        //查找学生所学的所有课程
        courseList = studentCourseInformationRepository.findBystudentId(studentId);
        int size = courseList.size();
        if(size==0) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        for( int i=0; i<size; i++){
            if (courseList.get(i) == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        }
        return courseList;
    }


}
