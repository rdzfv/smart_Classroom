package com.zjut.smartClassroom.repository;


import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.ProblemSetPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProblemSetDeleteRepository extends JpaRepository<ProblemSet,Integer> {


    /**
     *@author John
     *@date 2019/12/5 21:45
     */

//    @Modifying
//    @Transactional
//    @Query("update ProblemSet p set p.paperId = ?1 where problemSetId = ?2")
//    int updateRe(Integer paperId,Integer problemSetId);

    // 根据ProblemSetId删除对象
    int deleteByProblemSetId(Integer problemSetId);

}
