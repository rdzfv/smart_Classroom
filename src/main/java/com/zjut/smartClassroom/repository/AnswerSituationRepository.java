package com.zjut.smartClassroom.repository;


import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：ProblemAddRepository
 * @version:     1.0.0
 */
public interface AnswerSituationRepository extends JpaRepository<AnswerSituation, Integer> {
    //根据problemId查找答题情况
    AnswerSituation findByProblemId(int problemId);
}
