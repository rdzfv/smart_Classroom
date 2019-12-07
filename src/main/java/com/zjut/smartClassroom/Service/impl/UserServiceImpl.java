package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.StudentRepository;
import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.dataObject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//引入
    private StudentRepository studentRepository;


    // 通过用户id获取到用户信息
    @Override
    @Transactional
    public Student getUserById(int id) {
        Student student = studentRepository.findByStudentid(id);
        System.out.println(student);
        return student;

    }

    @Override
    @Transactional
    public Student login(Student student) throws BusinessException {
        System.out.println("进入login Service");
        System.out.println(studentRepository);
        System.out.println(student);
        Student studentResult = studentRepository.findByOpenidAndAndSessionkeyAndStudentaccountAndStudentnameAndStudentpassword(
                student.getOpenid(), student.getSessionkey(), student.getStudentaccount(), student.getStudentname(), student.getStudentpassword()
        );
        return studentResult;
    }
}
