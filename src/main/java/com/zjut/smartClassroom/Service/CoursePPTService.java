package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.CoursePPT;
import org.springframework.stereotype.Service;

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
    CoursePPT addCoursePPT(CoursePPT coursePPT);
}
