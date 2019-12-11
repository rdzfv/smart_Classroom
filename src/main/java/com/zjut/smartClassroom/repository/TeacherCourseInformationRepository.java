package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.TeacherCourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */
public interface TeacherCourseInformationRepository extends JpaRepository<TeacherCourseInformation, Integer>{
    // 根据教师id查找课程列表
    TeacherCourseInformation findByteacherId(int id);
}
