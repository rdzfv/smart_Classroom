package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:28:23
 * @description：StudentRepository
 * @version:     1.0.0
 */
public interface ProblemPaperRepository extends JpaRepository<ProblemPaper, ProblemPaper> {
    List<ProblemPaper> findAllByPaperId(int paperId);

    /**
     * @author John
     * @date 2019/12/5 21:45
     */
    // 根据paperId删除试卷内题目
    @Modifying
    @Transactional
    @Query("delete from ProblemPaper p where p.paperId = ?1 and p.problemId = ?2")
    int deleteProblemByPaperId(Integer paperId, Integer problemId);


    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 根据paper_id更改试卷试题
    @Modifying
    @Transactional
    @Query("update ProblemPaper p set p.problemId = ?1 where p.paperId = ?2 and p.problemId = ?3")
    int updatePaperProblemByPaperId(int problemIdNew, int paperId, int problemIdOld);


    /**
     *@author xyy
     *@date 2019/12/8 17:06
     */

    // 根据paperId和problemId查找记录
    ProblemPaper findByPaperIdAndProblemId(int paperId, int problemId);
}