package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.CoursePPT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.repository
 * @ClassName: CoursePPTRepository
 * @Author: FrankWu
 * @Description: ${description}
 * @Date: 2019/12/7 16:12
 * @Version: 1.0
 */


public interface CoursePPTRepository extends JpaRepository<CoursePPT, Integer> {
    CoursePPT save(CoursePPT coursePPT);
    ArrayList<CoursePPT> findCoursePPTSByCourseId(int courseId);
}
