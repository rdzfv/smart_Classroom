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

import java.util.ArrayList;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */

@Service
public class TeacherCourseInformationlmpl implements TeacherCourseInformationService{
    @Autowired(required = false)
    private TeacherCourseInformationRepository teacherCourseInformationRepository;

    /**
     * @Method findByteacherId
     * @Author Hefz
     * @Version  1.0
     * @Description
     * @Return java.util.ArrayList<com.zjut.smartClassroom.dataObject.TeacherCourseInformation>
     * @Exception
     * @Date 2019/12/11
     * @Time 9:13 PM
     */
    @Override
    @Transactional
    public ArrayList<TeacherCourseInformation> findByteacherId(int teacherId) throws BusinessException{
        ArrayList<TeacherCourseInformation> courseList = new ArrayList<>();

        //查找教师所教的所有课程
        courseList = teacherCourseInformationRepository.findByteacherId(teacherId);
        int size = courseList.size();
        if(size==0) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        for( int i=0; i<size; i++){
            if (courseList.get(i) == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        }
        return courseList;
    }

}
