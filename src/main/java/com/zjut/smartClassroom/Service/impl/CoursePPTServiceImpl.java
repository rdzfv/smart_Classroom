package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.CoursePPTService;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.repository.CoursePPTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service.impl
 * @ClassName: CoursePPTServiceImpl
 * @Author: FrankWu
 * @Description: ${description}
 * @Date: 2019/12/7 16:09
 * @Version: 1.0
 */

@Service
public class CoursePPTServiceImpl implements CoursePPTService {

    @Autowired(required = false)
    private CoursePPTRepository coursePPTRepository;

    /**
     * @Method addCoursePPT
     * @Author FrankWu
     * @Version  1.0
     * @Description 将ppt的url添加至数据库
     * @Return CoursePPT
     * @Exception
     * @Date 2019/12/7
     * @Time 16:33
     */
    @Override
    @Transactional
    public CoursePPT addCoursePPT(CoursePPT coursePPT){
        CoursePPT coursePPT1 = coursePPTRepository.save(coursePPT);
        return coursePPT1;
    }

    /**
     * @Method deleteBypptId
     * @Author Hefz
     * @Version  1.0
     * @Description
     * @Return int
     * @Exception
     * @Date 2019/12/11
     * @Time 10:48 PM
     */
    @Override
    @Transactional
    public int deleteBypptId(int pptId) {
        int flag = coursePPTRepository.deleteBypptId(pptId);
        System.out.println(flag);
        return flag;
    }
}
