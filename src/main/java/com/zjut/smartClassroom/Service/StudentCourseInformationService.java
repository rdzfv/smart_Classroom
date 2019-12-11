package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.StudentCourseInformation;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Method
 * @Author Hefz
 * @Version  1.0
 * @Description
 * @Return
 * @Exception
 * @Date 2019/12/11
 * @Time 9:40 PM
 */

@Service
public interface StudentCourseInformationService {
    // 通过课程student_id获取所学所有课程
    ArrayList<StudentCourseInformation> findBystudentId(int studentId) throws BusinessException;
}
