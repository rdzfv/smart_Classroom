package com.zjut.smartClassroom.repository;



import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<AnswerSituation, Integer> {
    //根据problemId查找答题情况
    AnswerSituation findByProblemId(int problemId);
}
