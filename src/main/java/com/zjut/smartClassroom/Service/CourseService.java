package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.error.BusinessException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: Hefz.
 * @date: 2019/12/4.
 * @description:
 */

@Service
public interface CourseService {
    //创建课程
    Course addCourse(Course course) throws  BusinessException;
}