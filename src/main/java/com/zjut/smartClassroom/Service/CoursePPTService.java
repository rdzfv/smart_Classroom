package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.CoursePPT;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service
 * @ClassName: CoursePPTService
 * @Author: FrankWu
 * @Description: ${description}
 * @Date: 2019/12/7 16:08
 * @Version: 1.0
 */

@Service
public interface CoursePPTService {
    CoursePPT addCoursePPT(CoursePPT coursePPT) throws BusinessException;
    ArrayList<CoursePPT> findPPTsByCourseId(int courseId) throws BusinessException;
}
