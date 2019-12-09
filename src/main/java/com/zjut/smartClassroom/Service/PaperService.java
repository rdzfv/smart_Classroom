package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaperService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有练习题
    List getAllData() throws BusinessException;
    // 新增一个练习卷信息
    int insertData(Paper newPaper) throws BusinessException;
    // 根据paperId删除试卷信息
    int deleteDataByPaperId(int paperId) throws BusinessException;
    // 根据paperId更新试卷信息
    int updateDataByPaperId(Paper newPaper) throws BusinessException;
    // 根据paperId查询试卷信息
    Paper getDataByPaperId(int paperId) throws BusinessException;
    // 通过练习卷ID查询练习卷实体
    Paper findPaperById(Integer paperId) throws BusinessException;
}
