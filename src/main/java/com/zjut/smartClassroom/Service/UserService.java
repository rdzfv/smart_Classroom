package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：UserService接口
 * @version:     1.0.0
 */
@Service
public interface UserService{
    //通过用户id获取用户对象的方法
    Student getUserById(int id);
    // 用户登录
    Student login(Student student) throws BusinessException;
    Teacher findTeacherById(int teacherId) throws BusinessException;
}
