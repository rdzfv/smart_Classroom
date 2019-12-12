package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ProblemSetService;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.ProblemSetCourse;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ProblemSetServiceImpl implements ProblemSetService {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private ProblemSetCourseRepository problemSetCourseRepository;
    @Autowired(required = false)
    private ProblemSetRepository problemSetRepository;

    @Override
    @Transactional
    public ProblemSetCourse getDataByCourseId(int id) {
        ProblemSetCourse problemSetCourse = problemSetCourseRepository.findByCourseId(id);
        System.out.println(problemSetCourse);
        return problemSetCourse;
    }

    @Override
    @Transactional
    public ProblemSet getDataByProblemSetId(int id) {
        ProblemSet problemSet = problemSetRepository.findByProblemSetId(id);
        System.out.println(problemSet);
        return problemSet;
    }

    @Override
    public ProblemSet updateDataByProblemSetId(ProblemSet problemSetPart)  throws BusinessException {
        // 数据库查出待更新对象
        ProblemSet problemSetFindingResult = problemSetRepository.findByProblemSetId(problemSetPart.getProblemSetId());
        if (problemSetFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        System.out.println(problemSetFindingResult.getProblemSetName());
        BeanUtil.copyProperties(problemSetPart, problemSetFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        ProblemSet problemSetResult = problemSetRepository.save(problemSetFindingResult);
        return problemSetResult;
    }

    @Override
    @Transactional
    public int deleteDataByProblemSetId(int id) {
        int flag = problemSetRepository.deleteByProblemSetId(id);
        System.out.println(flag);
        return flag;
    }

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

    /**
     * @Method findByteacherId
     * @Author Hefz
     * @Version  1.0
     * @Description
     * @Return java.util.ArrayList<com.zjut.smartClassroom.dataObject.ProblemSet>
     * @Exception
     * @Date 2019/12/12
     * @Time 2:46 PM
     */
    // 通过teacher_id获取作业集
    @Override
    @Transactional
    public ArrayList<ProblemSet> findByteacherId(int teacherId) throws BusinessException{
        ArrayList<ProblemSet> problemList = new ArrayList<>();

        //查找教师所教的所有课程
        problemList = problemSetRepository.findByteacherId(teacherId);
        int size = problemList.size();
        if(size==0) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        for( int i=0; i<size; i++){
            if (problemList.get(i) == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        }
        return problemList;
    }
}
