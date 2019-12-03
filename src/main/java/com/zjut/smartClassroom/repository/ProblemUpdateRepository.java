package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProblemUpdateRepository extends JpaRepository<Problem, Problem> {
    @Modifying
    @Transactional
    @Query("update Problem p set p.problemInfo=?1,p.problemAns=?2,p.problemChoose1=?3,p.problemChoose2=?4,p.problemChoose3=?5,p.problemChoose4=?6,p.problemExplain=?7 where p.problemId=?8")
    int update(String problemInfo,int problemAns,String problemChoose1,String problemChoose2,String problemChoose3,String problemChoose4,String problemExplain,int problemId);

    Problem findAllByProblemId(int priblemId);
}
