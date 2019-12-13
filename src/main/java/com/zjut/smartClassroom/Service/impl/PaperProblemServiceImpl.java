package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.PaperProblemService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.view.PaperProblemView;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.PaperProblemViewRepository;
import com.zjut.smartClassroom.repository.PaperRepository;
import com.zjut.smartClassroom.repository.ProblemPaperRepository;
import com.zjut.smartClassroom.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaperProblemServiceImpl implements PaperProblemService {


    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    ProblemPaperRepository paperProblemRepository;
    @Autowired(required = false)
    ProblemRepository problemRepository;
    @Autowired(required = false)
    PaperRepository paperRepository;
    @Autowired(required = false)
    PaperProblemViewRepository paperProblemViewRepository;

    // 根据paperId来插入problem
    @Override
    @Transactional
    public int insertProblemByPaperId(ProblemPaper newPaperProblem) throws BusinessException {
        // 判断paperId是否合法
        Paper paperResult = paperRepository.findByPaperId(newPaperProblem.getPaperId());
        if (paperResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        // 判断problemId是否存在
        Problem problemResult = problemRepository.findByProblemId(newPaperProblem.getProblemId());
        if (problemResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        // problemId是否已经被添加
        ProblemPaper problemPaperResult = paperProblemRepository.findByPaperIdAndProblemId(newPaperProblem.getPaperId(), newPaperProblem.getProblemId());
        if (problemPaperResult != null) throw new BusinessException(EnumBusinessError.ADD_FAILED);

        paperProblemRepository.save(newPaperProblem);
        return 1;
    }

    // 根据paperId来查询试卷
    @Override
    @Transactional
    public List<PaperProblemView> getDataByPaperId(int paperId)  throws BusinessException {
        // 判断id是否合法
        if (paperRepository.findByPaperId(paperId) == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        List<PaperProblemView> paperProblemViewList = paperProblemViewRepository.findAllByPaperId(paperId);
        System.out.println(paperProblemViewList);
        if (paperProblemViewList.size() == 0) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return paperProblemViewList;
    }

    // 根据paperId删除试卷内题目
    @Override
    public int deletePaperProblem(int paperId, int problemId) throws BusinessException {
        // 判断paperId是否合法
        Paper paperResult = paperRepository.findByPaperId(paperId);
        if (paperResult == null) throw new BusinessException(EnumBusinessError.DELETE_FAILED);
        // 判断problemId是否存在
        Problem problemResult = problemRepository.findByProblemId(problemId);
        if (problemResult == null) throw new BusinessException(EnumBusinessError.DELETE_FAILED);
        // problemId是否已经被添加
        ProblemPaper problemPaperResult = paperProblemRepository.findByPaperIdAndProblemId(paperId, problemId);
        if (problemPaperResult == null) throw new BusinessException(EnumBusinessError.DELETE_FAILED);

        int flag = paperProblemRepository.deleteProblemByPaperId(paperId, problemId);
        System.out.println(flag);
        return flag;
    }

    @Override
    public List<PaperProblemView> createNewPaper(String problemList, String paperName) throws BusinessException {
        // 创建paper
        Paper paper = new Paper();
        paper.setPaperName(paperName);
        Paper paperResult = paperRepository.save(paper);
        if (paperResult == null) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        // 获取新创建的paperId
        int paperId = paperResult.getPaperId();
        // problemList字符串转数组
        String[] intArr = problemList.split(",");
        // 循环遍历插入paper和problem的练习
        ProblemPaper paperProblem;
        for (String i : intArr) {
            paperProblem = new ProblemPaper();
            int temp = Integer.parseInt(i);
            // 判断problemId是否合法
            Problem problemResult = problemRepository.findByProblemId(temp);
            if (problemResult == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
            // 为paperProblem实例添加属性
            paperProblem.setPaperId(paperId);
            paperProblem.setProblemId(temp);
            insertProblemByPaperId(paperProblem);
        }
        List<PaperProblemView> paperProblemList = getDataByPaperId(paperId);
        if (paperProblemList.size() == 0) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_PROBLEM_CREATE_FAILED);
            throw businessException;
        }
        return paperProblemList;
    }

    @Override
    public Paper updatePaper(Paper paper) throws BusinessException {
        // 数据库查出待更新对象
        Paper paperFindingResult = paperRepository.findByPaperId(paper.getPaperId());
        if (paperFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(paper, paperFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Paper paperResult = paperRepository.save(paperFindingResult);
        return paperResult;
    }

    // 根据paperId来修改试卷
    @Override
    public int updatePaperProblem(ProblemPaper newPaperProblem,int newProblemId) {
        int flag = paperProblemRepository.updatePaperProblemByPaperId(newProblemId, newPaperProblem.getPaperId(), newPaperProblem.getProblemId());
        System.out.println(flag);
        return flag;
    }

}
