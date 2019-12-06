package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperImpl implements PaperService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    List<Paper> paperList;
    @Autowired(required = false)
    Paper paper;
    @Autowired(required = false)
    PaperAllScanRepository paperAllScanRepository;
    @Autowired(required = false)
    PaperInsertRepository paperInsertRepository;
    @Autowired(required = false)
    PaperDeleteRepository paperDeleteRepository;
    @Autowired(required = false)
    PaperUpdateRepository paperUpdateRepository;
    @Autowired(required = false)
    PaperFindByIdRepository paperFindByIdRepository;

    @Override
    @Transactional
    public List getAllData() {
        paperList = paperAllScanRepository.findAll();
        System.out.println(paperList);
        if (paperList.size() != 0)
            return paperList;
        return null;
    }

    @Override
    @Transactional
    public int insertData(Paper newPaper) {
        paperInsertRepository.save(newPaper);
        return 1;
    }

    @Override
    @Transactional
    public int deleteDataByPaperId(int paperId) {
        int flag = paperDeleteRepository.deleteByPaperId(paperId);
        System.out.println(flag);
        return flag;
    }

    @Override
    public int updateDataByPaperId(Paper newPaper) {
        int flag = paperUpdateRepository.updateDataByPaperId(newPaper.getPaperName(), newPaper.getPaperId());
        System.out.println(flag);
        return 1;
    }

    @Override
    @Transactional
    public Paper getDataByPaperId(int paperId) {
        paper = paperFindByIdRepository.findByPaperId(paperId);
        System.out.println(paper);
        return paper;
    }


}
