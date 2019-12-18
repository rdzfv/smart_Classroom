package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.CoursePPTService;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.CoursePPTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
    public CoursePPT addCoursePPT(CoursePPT coursePPT) throws BusinessException{
        CoursePPT coursePPT1 = coursePPTRepository.save(coursePPT);
        return coursePPT1;
    }


    @Override
    public ArrayList<CoursePPT> findPPTsByCourseId(int courseId) throws BusinessException {
        ArrayList<CoursePPT> coursePPTS = coursePPTRepository.findCoursePPTSByCourseId(courseId);
        if (coursePPTS == null) throw new BusinessException(EnumBusinessError.COURSE_NOT_EXIST);
        return coursePPTS;
    }
}
