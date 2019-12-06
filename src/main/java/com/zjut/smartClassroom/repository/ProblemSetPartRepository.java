package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.ProblemSetPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProblemSetPartRepository extends JpaRepository<ProblemSetPart,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 根据练习集id查询练习集情况
    ProblemSetPart findByProblemSetId(Integer problemSetid);

}
