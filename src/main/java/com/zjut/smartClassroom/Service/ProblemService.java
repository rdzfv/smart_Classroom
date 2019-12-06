package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有题目
    List<Problem> getAllData();
}
