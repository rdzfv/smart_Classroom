package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ClassService;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.dataObject.Course;
import com.zjut.smartClassroom.dataObject.Teacher;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.ClassRepository;
import com.zjut.smartClassroom.repository.CourseRepository;
import com.zjut.smartClassroom.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author ：dzy
 * @date ：Created in 2019/12/03 12:45:23
 * @description：ClassService接口的实现类
 * @version: 1.0.0
 */
@Service
public class ClassServiceImpl implements ClassService {
    // 引入
    @Autowired(required = false)
    private ClassRepository classRepository;
    @Autowired(required = false)
    private TeacherRepository teacherRepository;
    @Autowired(required = false)
    private CourseRepository courseRepository;

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/05 20:00:23
     * @description：获取所有的教学班信息
     * @version: 1.0.0
     */
    @Override
    @Transactional
    public ArrayList<Class> getAllClass(int teacherId) throws BusinessException {
        ArrayList<Class> classList = new ArrayList<>();

        //查找所有教学班信息
        classList = classRepository.findAllByTeacherId(teacherId);
        if (classList == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);

        return classList;
    }

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/06 9:23:05
     * @description：增加教学班信息
     * @version: 1.0.0
     */
    @Override
    public Class addClass(Class class_) throws BusinessException {
        // 验证teacherId是否存在
        Teacher teacherResult = teacherRepository.findByTeacherId(class_.getTeacherId());
        if (teacherResult == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        // 验证courseId是否存在
        Course courseResult = courseRepository.findByCourseId(class_.getCourseId());
        if (courseResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);

        Class success = classRepository.save(class_);
        return success;
    }

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/06 10:10:05
     * @description：修改教学班信息
     * @version: 1.0.0
     */
    @Override
    public Class updateClass(Class class_) throws BusinessException {
        //查询待更新教学班
        Class classFindingResult = classRepository.findByTeacherIdAndCourseId(class_.getTeacherId(), class_.getCourseId());
        if (classFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        System.out.println(classFindingResult.getClassOpenyear());
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(class_, classFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Class classResult = classRepository.save(classFindingResult);
        if (classResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return classResult;
    }
}
