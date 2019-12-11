package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.TeacherCourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */
public interface TeacherCourseInformationRepository extends JpaRepository<TeacherCourseInformation, Integer>{

    //查找教师所教的所有课程
    ArrayList<TeacherCourseInformation> findByteacherId(int id);
}
