package com.zjut.smartClassroom.Service.impl;

import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.repository.PaperRepository;
import com.zjut.smartClassroom.repository.ProblemSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service.impl
 * @ClassName: PromblemSetServiceImpl
 * @Author: FrankWu
 * @Description: 实现ProblemSetService接口
 * @Date: 2019/12/7 11:21
 * @Version: 1.0
 */

@Service
public class PromblemSetServiceImpl implements ProblemSetService {
    // 引入
    @Autowired(required = false)
    private ProblemSetRepository problemSetRepository;

    /**
     * @Method addProblemSet
     * @Author FrankWu
     * @Version  1.0
     * @Description
     * @Return com.zjut.smartClassroom.dataObject.ProblemSet
     * @Exception
     * @Date 2019/12/7
     * @Time 14:45
     */
    @Override
    @Transactional
    public ProblemSet addProblemSet(ProblemSet problemSet) throws BusinessException{
        ProblemSet success = problemSetRepository.save(problemSet);
        return success;
    }

}
