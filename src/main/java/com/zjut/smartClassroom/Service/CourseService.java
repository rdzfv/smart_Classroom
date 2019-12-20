package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.view.StudentCourseDetailView;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service
 * @ClassName: CourseService
 * @Author: FrankWu
 * @Description: Course接口
 * @Date: 2019/12/7 09:11
 * @Version: 1.0
 */

@Service
public interface CourseService {
    // 通过id更新课程信息
    Course updateCourse(Course course) throws BusinessException;
    // 通过id查询并返回课程实体
    Course findCourseById(Integer courseId) throws BusinessException;
    // 通过学号返回选修的课程信息
    List<StudentCourseDetailView> findCourseDetailByStudentId(Integer studentId) throws  BusinessException;
    // 创建课程
    Course createCourse(Course course) throws BusinessException;
}
