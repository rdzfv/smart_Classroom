package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.repository
 * @ClassName: CourseRepository
 * @Author: FrankWu
 * @Description: CourseRepository
 * @Date: 2019/12/7 09:58
 * @Version: 1.0
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course save(Course course);
    Course findByCourseId(int id);
}
