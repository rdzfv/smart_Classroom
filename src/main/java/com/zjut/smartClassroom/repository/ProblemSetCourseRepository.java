package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemSetCourseRepository extends JpaRepository<ProblemSetCourse,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 根据课程id号查找相关信息
    ProblemSetCourse findByCourseId(Integer id);
}
