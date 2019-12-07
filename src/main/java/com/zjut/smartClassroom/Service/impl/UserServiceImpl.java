package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.StudentRepository;
import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.dataObject.*;
import com.zjut.smartClassroom.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：UserService接口的实现类
 * @version:     1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//引入
    private StudentRepository studentRepository;
    @Autowired(required = false)//引入
    private TeacherRepository teacherRepository;
    @Autowired(required = false)//引入
    private Student student;


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/02 12:45:23
     * @description：通过用户id获取用户信息
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Student getUserById(int id) {
        student = studentRepository.findByStudentId(id);
        return student;

    }

    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/02 12:45:23
     * @description：用户登录(传入student对象)
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Student login(Student student) throws BusinessException {
        Student studentResult = studentRepository.findByOpenIdAndSessionKeyAndStudentAccountAndStudentNameAndStudentPassword(
                student.getOpenId(), student.getSessionKey(), student.getStudentAccount(), student.getStudentName(), student.getStudentPassword()
        );
        return studentResult;
    }

    /**
     * @Method findTeacherById
     * @Author FrankWu
     * @Version  1.0
     * @Description
     * @Return com.zjut.smartClassroom.dataObject.Teacher
     * @Exception
     * @Date 2019/12/7
     * @Time 16:34
     */
    @Override
    @Transactional
    public Teacher findTeacherById(int teacherId) throws BusinessException{
        Teacher teacherResult = teacherRepository.findTeacherByTeacherId(teacherId);
        if(teacherResult == null){
            throw new BusinessException(EnumBusinessError.TEACHER_NOT_EXIST);
        }
        return teacherResult;
    }
}
