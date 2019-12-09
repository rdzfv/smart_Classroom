package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    PaperRepository paperRepository;

    @Override
    @Transactional
    public List getAllData() {
        List<Paper> paperList = paperRepository.findAll();
        System.out.println(paperList);
        if (paperList.size() != 0)
            return paperList;
        return null;
    }

    @Override
    @Transactional
    public int insertData(Paper newPaper) throws BusinessException {
        Paper paperResult = paperRepository.save(newPaper);
        System.out.println("成功插入的paper:" + paperResult);
        if (paperResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        return 1;
    }

    @Override
    @Transactional
    public int deleteDataByPaperId(int paperId) {
        int flag = paperRepository.deleteByPaperId(paperId);
        System.out.println(flag);
        return flag;
    }

    @Override
    public int updateDataByPaperId(Paper newPaper) {
        int flag = paperRepository.updateDataByPaperId(newPaper.getPaperName(), newPaper.getPaperId());
        System.out.println(flag);
        return 1;
    }

    @Override
    @Transactional
    public Paper getDataByPaperId(int paperId) throws BusinessException{
        Paper paper = paperRepository.findByPaperId(paperId);
        if (paper == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        System.out.println(paper);
        return paper;
    }

    /**
     * @Method findPaperById
     * @Author FrankWu
     * @Version  1.0
     * @Description
     * @Return com.zjut.smartClassroom.dataObject.Paper
     * @Exception
     * @Date 2019/12/7
     * @Time 16:34
     */
    @Override
    @Transactional
    public Paper findPaperById(Integer paperId) throws BusinessException {
        Paper paperResult = paperRepository.findByPaperId(paperId);
        if(paperResult == null){
            throw new BusinessException(EnumBusinessError.PAPER_NOT_EXIST);
        }
        return paperResult;
    }
}
