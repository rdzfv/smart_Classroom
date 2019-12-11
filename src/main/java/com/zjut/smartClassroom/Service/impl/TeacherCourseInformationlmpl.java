package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.TeacherCourseInformationService;
import com.zjut.smartClassroom.dataObject.TeacherCourseInformation;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */

@Service
public class TeacherCourseInformationlmpl implements TeacherCourseInformationService{
    @Autowired(required = false)
    private TeacherCourseInformationRepository teacherCourseInformationRepository;


    @Override
    @Transactional
    public TeacherCourseInformation findByteacherId(int teacherId) throws BusinessException{
        TeacherCourseInformation courseResult = teacherCourseInformationRepository.findByteacherId(teacherId);
        if (courseResult == null) throw new BusinessException(EnumBusinessError.COURSE_NOT_EXIST);
        return courseResult;
    }

}
