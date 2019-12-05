package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.dataObject.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:11:23
 * @description: problemSetRepository
 * @version    : 1.0.0
 */

@Repository
public interface ProblemSetRepository extends JpaRepository<ProblemSet, Integer> {
    ProblemSet findByProblemSetId(int id);
}