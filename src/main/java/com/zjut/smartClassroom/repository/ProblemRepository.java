package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
