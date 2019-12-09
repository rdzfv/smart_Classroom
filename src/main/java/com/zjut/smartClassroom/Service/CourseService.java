package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

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
}
