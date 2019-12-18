package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

/**
 * @author: Hefz.
 * @date: 2019/12/18.
 * @description:
 */

@Service
public interface StudentService {

    // 通过id查询并返回学生实体
    Student findStudentByStudentId(Integer studentId) throws BusinessException;

}
