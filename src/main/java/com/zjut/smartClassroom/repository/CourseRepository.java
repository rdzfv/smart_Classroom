package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: Hefz.
 * @date: 2019/12/5.
 * @description:
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Course>{
    //update course
    Course save(Course course);
}