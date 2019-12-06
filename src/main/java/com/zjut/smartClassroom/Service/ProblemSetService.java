package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.dataObject.ProblemSetPart;
import org.springframework.stereotype.Service;

@Service
public interface ProblemSetService {
    // 通过课程id获取对象方法
    public ProblemSetCourse getDataByCourseId(int id);

    // 通过练习集id获取对象方法
    public ProblemSetPart getDataByProblemSetId(int id);

    // 通过练习集id修改练习集信息方法
    int updateDataByProblemSetId(ProblemSetPart problemSetPart);

    int deleteDataByProblemSetId(int id);

}
