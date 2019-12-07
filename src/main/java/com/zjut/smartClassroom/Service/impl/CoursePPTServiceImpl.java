package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.CoursePPTService;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.repository.CoursePPTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public CoursePPT addCoursePPT(CoursePPT coursePPT){
        CoursePPT coursePPT1 = coursePPTRepository.save(coursePPT);
        return coursePPT1;
    }
}
