package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service.impl
 * @ClassName: CourseServiceImpl
 * @Author: FrankWu
 * @Description: 实现CourserService接口
 * @Date: 2019/12/7 09:12
 * @Version: 1.0
 */

@Service
public class CourseServiceImpl implements CourseService {
    // 引入
    @Autowired(required = false)
    private CourseRepository courseRepository;

    /**
     * @Method updateCourse
     * @Author FrankWu
     * @Version  1.0
     * @Description 根据courseId修改课程信息
     * @Return com.zjut.smartClassroom.dataObject.Course
     * @Exception BusinessException
     * @Date 2019/12/7
     * @Time 09:50
     */
    @Override
    @Transactional
    public Course updateCourse(Course course) throws BusinessException {
        // 数据库查出待更新对象
        Course courseFindingResult = courseRepository.findByCourseId(course.getCourseId());
        if (courseFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(course, courseFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Course courseResult = courseRepository.save(courseFindingResult);
        if (courseResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return courseResult;
    }

    /**
     * @Method findCourseById
     * @Author FrankWu
     * @Version  1.0
     * @Description 通过课程ID查询课程实体
     * @Return com.zjut.smartClassroom.dataObject.Course
     * @Exception BusinessException
     * @Date 2019/12/7
     * @Time 13:10
     */
    @Override
    @Transactional
    public Course findCourseById(Integer courseId) throws BusinessException{
        Course courseResult = courseRepository.findByCourseId(courseId);
        if (courseResult == null) throw new BusinessException(EnumBusinessError.COURSE_NOT_EXIST);
        return courseResult;
    }

}
