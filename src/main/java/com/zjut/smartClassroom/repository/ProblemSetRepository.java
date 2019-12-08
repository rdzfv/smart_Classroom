package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:11:23
 * @description: problemSetRepository
 * @version    : 1.0.0
 */

@Repository
public interface ProblemSetRepository extends JpaRepository<ProblemSet, Integer> {
    ProblemSet findByProblemSetId(int id);

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 根据ProblemSetId删除对象
    int deleteByProblemSetId(Integer problemSetId);

    // 根据练习集id查询练习集情况
    ProblemSet findByProblemSetId(Integer problemSetid);

    // 根据练习集id修改练习集
    @Modifying
    @Transactional
    @Query("update ProblemSet p set p.problemSetName = ?1,p.problemSetDetail = ?2,p.problemReleaseTime = ?3,p.problemSetPicUrl = ?4,p.paperId = ?5 where p.problemSetId = ?6")
    int updateDataByProblemSetId(String problemSetName, String problemSetDetail, Date problemReleaseTime, String problemSetPicUrl, int paperId, int problemSetId);
}