package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ClassService;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.dataObject.ClassInformation;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.ClassInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description:
 */
@Service
public class ClassServicelmpl implements ClassService{
    @Autowired(required = false)//引入
    private ClassInformation classInformation;
    @Autowired(required = false)//引入
    private ClassInformationRepository classInformationRepository;

    /**
     * @author     ：Hefz
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：use classId to get class information
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public ClassInformation getPPTSetByClassId(int classId) throws BusinessException {
        classInformation= classInformationRepository.findByClassId(classId);
        System.out.println(classInformation);
        return  classInformation;
    }
}
