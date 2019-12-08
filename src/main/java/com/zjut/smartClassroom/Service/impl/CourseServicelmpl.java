package com.zjut.smartClassroom.Service.impl;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServicelmpl implements CourseService {
    @Autowired(required = false)//引入
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public Course addCourse(Course course) throws BusinessException {
        Course success= courseRepository.save(course);
        return success;
    }
}