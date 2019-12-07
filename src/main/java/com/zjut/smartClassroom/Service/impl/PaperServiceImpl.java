package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
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
    public int insertData(Paper newPaper) {
        paperRepository.save(newPaper);
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
    public Paper getDataByPaperId(int paperId) {
        Paper paper = paperRepository.findByPaperId(paperId);
        System.out.println(paper);
        return paper;
    }


}
