package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public interface UserService{
    //通过用户id获取用户对象的方法
    Student getUserById(int id);
    Student login(Student student) throws BusinessException;
}
