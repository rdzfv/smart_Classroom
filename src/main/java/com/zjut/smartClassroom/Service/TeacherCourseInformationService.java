package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.TeacherCourseInformation;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

/**
 * @Method
 * @Author Hefz
 * @Version  1.0
 * @Description
 * @Return
 * @Exception
 * @Date 2019/12/11
 * @Time 11:05 AM
 */

@Service
public interface TeacherCourseInformationService {
    // 通过课程id获取对象方法
    TeacherCourseInformation findByteacherId(int teacherId) throws BusinessException;
}
