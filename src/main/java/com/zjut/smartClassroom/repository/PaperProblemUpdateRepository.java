package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.PaperProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaperProblemUpdateRepository extends JpaRepository<PaperProblem,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 根据paper_id更改试卷试题
    @Modifying
    @Transactional
    @Query("update PaperProblem p set p.problemId = ?1 where p.paperId=?2 and p.problemId=?3")
    int updatePaperProblemByPaperId(int problemIdNew,int paperId,int problemIdOld);

}
