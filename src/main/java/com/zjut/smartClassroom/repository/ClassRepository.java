package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author ：dzy
 * @date ：Created in 2019/12/05 19:45:23
 * @description： ClassRepository
 * @version: 1.0.0
 */
public interface ClassRepository extends JpaRepository<Class, Class> {
    //查询所有教学班信息
    ArrayList<Class> findAllByTeacherId(int teacherId);

    //新增教学班信息
    Class save(Class class_);

    //根据teacherId和courseId查询教学班信息
    Class findByTeacherIdAndCourseId(int teacherId,int courseId);
}
