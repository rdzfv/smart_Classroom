package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.StudentCourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */
public interface StudentCourseInformationRepository extends JpaRepository<StudentCourseInformation, Integer>{

    // 根据student_id查找课程列表
    ArrayList<StudentCourseInformation> findBystudentId(int id);
}
