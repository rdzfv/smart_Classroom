package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.StudentDO;
import com.zjut.smartClassroom.error.BusinessException;

import java.util.List;

public interface UserService{
    //通过用户id获取用户对象的方法
    StudentDO getUserById(Integer id);
    StudentDO login(StudentDO studentDO) throws BusinessException;
}
