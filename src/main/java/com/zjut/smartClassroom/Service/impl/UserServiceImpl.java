package com.zjut.smartClassroom.Service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.Dao.*;
import com.zjut.smartClassroom.dataObject.*;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//引入
    private StudentDOMapper studentDOMapper;




    //通过用户id获取到用户信息/////////////////////////////////////////////////////////////
    @Override
    public StudentDO getUserById(Integer id){
        //调用userdomapping获取到对用得到用户dataobject
        StudentDO studentDO=studentDOMapper.selectByPrimaryKey(id);
        System.out.println(studentDO.getStudentId());
        System.out.println(studentDO.getStudentName());
        return studentDO;

    }

    @Override
    public StudentDO login(StudentDO studentDO) throws BusinessException {
        if(studentDO.getStudentAccount() == "" || studentDO.getStudentPassword() == "" ||
                studentDO.getStudentName() == ""  || studentDO.getOpenid() == "" ||
                studentDO.getSessionKey() == ""
        ){
            System.out.println("参数不全");
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        StudentDO studentDOResult = studentDOMapper.selectByStudentDO(studentDO).get(0);
        System.out.println(studentDOResult.getStudentAccount());
        System.out.println(studentDOResult.getStudentName());
        return studentDO;
    }
}
