package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有练习题
    List getAllData();
    // 新增一个练习卷信息
    int insertData(Paper newPaper);
    // 根据paperId删除试卷信息
    int deleteDataByPaperId(int paperId);
    // 根据paperId更新试卷信息
    int updateDataByPaperId(Paper newPaper);
    // 根据paperId查询试卷信息
    Paper getDataByPaperId(int paperId);
}