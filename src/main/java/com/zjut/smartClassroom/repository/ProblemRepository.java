package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemAddRepository
 * @version:     1.0.0
 */
public interface ProblemRepository extends JpaRepository<Problem, Problem> {
    // 更新problem
    Problem save(Problem problem);
    // 根据problemId查找problem
    Problem findByProblemId(int problemId);

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有题目
    List<Problem> findAll();
}
