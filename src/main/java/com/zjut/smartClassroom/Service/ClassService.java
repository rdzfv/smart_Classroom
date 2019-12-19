package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：dzy
 * @date ：Created in 2019/12/05 19:37:04
 * @description：ClassService接口
 * @version: 1.0.0
 */
@Service
public interface ClassService {
    // 获取全部教学班的信息
    ArrayList<Class> getAllClassByTeacherId(int teacherId) throws BusinessException;

    // 获取全部班级信息
    List<Class> getAllClass() throws BusinessException;

    //修改教学班信息
    Class updateClass(Class class_) throws BusinessException;

    //增加新的教学班
    Class addClass(Class class_) throws BusinessException;
}
