package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.PaperProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaperProblemDeleteByPaperIdRepository extends JpaRepository<PaperProblem, Integer> {
    /**
     * @author John
     * @date 2019/12/5 21:45
     */
    // 根据paperId删除试卷内题目
    @Modifying
    @Transactional
    @Query("delete from PaperProblem p where p.paperId = ?1 and p.problemId = ?2")
    int deleteProblemByPaperId(Integer paperId,Integer problemId);
}
