package com.zjut.smartClassroom.Service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.StudentService;
import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author: Hefz.
 * @date: 2019/12/18.
 * @description:
 */

@Service
public class StudentServicelmpl implements  StudentService{
    // 引入
    @Autowired(required = false)
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public Student findStudentByStudentId(Integer studentId) throws BusinessException{
        Student studentResult = studentRepository.findStudentByStudentId(studentId);
        if (studentResult == null) throw new BusinessException(EnumBusinessError.STUDENT_NOT_EXIST);
        return studentResult;
    }
}
