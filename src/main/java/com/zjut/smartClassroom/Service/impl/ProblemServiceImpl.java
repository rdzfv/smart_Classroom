package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.*;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.model.MyAnswersModel;
import com.zjut.smartClassroom.model.ProblemsDetailIInProblemSetModel;
import com.zjut.smartClassroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemService接口的实现类
 * @version:     1.0.0
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    // 引入
    @Autowired(required = false)
    private AnswerSituationRepository answerSituationRepository;
    @Autowired(required = false)
    private ProblemRepository problemRepository;
    @Autowired(required = false)
    private ProblemSetRepository problemSetRepository;
    @Autowired(required = false)
    private ProblemPaperRepository problemPaperRepository;
    @Autowired(required = false)
    private TeacherRepository teacherRepository;
    @Autowired(required = false)
    private CourseRepository courseRepository;
    @Autowired(required = false)
    private AnswerRepository answerRepository;


    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：根据problemsetId获取学生答题情况详情
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public ArrayList<AnswerSituation> getProblemSetStudentAnsweringDetailByProblemSetId(int problemSetId) throws BusinessException {
        ArrayList<AnswerSituation> answerSituationList = new ArrayList<>();

        // 通过problemSetId查找problems
        ArrayList<ProblemsDetailIInProblemSetModel> problemsDetailIInProblemSetModels = getProblemsByProblemSetId(problemSetId);
        if (problemsDetailIInProblemSetModels == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        int size = problemsDetailIInProblemSetModels.size();
        ArrayList<Integer> problemIds = new ArrayList<Integer>();
        for (int i = 0; i < size; i ++) {
            System.out.println(problemsDetailIInProblemSetModels.get(i).getProblemId());
            problemIds.add(problemsDetailIInProblemSetModels.get(i).getProblemId());
        }

        // 根据problemIds查找题目详情s
        for (int i = 0; i < size; i++) {
            AnswerSituation answerSituation = answerSituationRepository.findByProblemId(problemIds.get(i));
            if (answerSituation == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
            // 加入ArrayList
            answerSituationList.add(answerSituation);
        }

        return answerSituationList;
    }


    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：修改问题
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem updateProblem(Problem problem) throws BusinessException {
        // 数据库查出待更新对象
        Problem problemFindingResult = problemRepository.findByProblemId(problem.getProblemId());
        if (problemFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(problem, problemFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Problem problemResult = problemRepository.save(problemFindingResult);
        if (problemResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problemResult;
    }


    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：根据problemId获取问题详情
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem getProblem(int problemId) throws BusinessException {
        Problem problem = problemRepository.findByProblemId(problemId);
        if (problem == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        return problem;
    }


    /**
     * @author     ：dzy
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：添加问题（传入problem对象）
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Problem addProblem(Problem problem) throws BusinessException {
        Problem success = problemRepository.save(problem);
        return success;
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/04 23:05:14
     * @description：根据problemSetId获取问题详情
     * @version:     1.0.0
     */
    @Override
    public ArrayList<ProblemsDetailIInProblemSetModel> getProblemsByProblemSetId(int problemSetId) throws BusinessException {
        ArrayList<ProblemsDetailIInProblemSetModel> result = new ArrayList<ProblemsDetailIInProblemSetModel>();

        // 通过ProblemSetId获取对应的paperId和fatherProblemSetName和fatherCourseId和fatherCourseTeacherId
        ProblemSet problemSet = problemSetRepository.findByProblemSetId(problemSetId);
        if (problemSet == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        int paperId = problemSet.getPaperId();
        String problemSetName = problemSet.getProblemSetName();
        int fatherCourseId = problemSet.getCourseId();
        int fatherCourseTeacherId = problemSet.getTeacherId();

        // 通过fatherCourseId获取对应的fatherCourseName
        Course courseInstance = courseRepository.findByCourseId(fatherCourseId);
        if (courseInstance == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        String courseName = courseInstance.getCourseName();

        // 通过fatherCourseTeacherId获取fatherTeacherName
        Teacher teacherInstance = teacherRepository.findByTeacherId(fatherCourseTeacherId);
        if (teacherInstance == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        String teacherName = teacherInstance.getTeacherName();

        // 通过paperId获取problemIds
        List<ProblemPaper> problemPaperList = problemPaperRepository.findAllByPaperId(paperId);
        if (problemPaperList == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);

        // 遍历List<ProblemPaper>，取出problemId查询题目s信息
        int size = problemPaperList.size();
        for (int i = 0; i < size; i ++) {
            ProblemsDetailIInProblemSetModel problemsDetailIInProblemSetModelInstance = new ProblemsDetailIInProblemSetModel();
            int problemId = problemPaperList.get(i).getProblemId();

            // 根据problemId查询题目信息
            Problem problem = problemRepository.findByProblemId(problemId);
            if (problem == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);

            // 使用hutool BeanUtil进行对象拷贝（忽略null值）BeanUtil.copyProperties(data, target, )
            BeanUtil.copyProperties(problem, problemsDetailIInProblemSetModelInstance, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

            // 加入父节点信息
            problemsDetailIInProblemSetModelInstance.setFatherProblemSetName(problemSetName);
            problemsDetailIInProblemSetModelInstance.setFatherCourseTeacher(teacherName);
            problemsDetailIInProblemSetModelInstance.setFatherCourseName(courseName);

            result.add(problemsDetailIInProblemSetModelInstance);
        }
        return result;
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/05 13:39:19
     * @description： 通过学生Id
     * @version:     1.0.0
     */
    @Override
    public int addMyResult(int studentId, int courseId, int problemSetId, ArrayList<ProblemsDetailIInProblemSetModel> problemResults, String myAns) throws BusinessException {
        // 获取学生答题情况字符串解析为字符串数组
        String[] myAnsList = myAns.split(",");

        int size = problemResults.size();
        for (int i = 0; i < size; i ++) {
            // 校验答案正误（通过problemId获取正确答案）
            int isTrue = 0;
            Problem problemResult = problemRepository.findByProblemId(problemResults.get(i).getProblemId());
            if (problemResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
            int correctAns = problemResult.getProblemAns();
            if (correctAns == Integer.parseInt(myAnsList[i])) isTrue = 1;

            // 构造Answer实例
            Answer answerInstance = new Answer();
            answerInstance.setStudentId(studentId);
            answerInstance.setProblemId(problemResults.get(i).getProblemId());
            answerInstance.setProblemSetId(problemSetId);
            answerInstance.setStudentAns(Integer.parseInt(myAnsList[i]));
            answerInstance.setIsTrue(isTrue);

            // 新增答题记录
            Answer result = answerRepository.save(answerInstance);
            if (result == null) {
                throw new BusinessException(EnumBusinessError.ADD_FAILED);
            }
        }

        return 1;
    }
}
