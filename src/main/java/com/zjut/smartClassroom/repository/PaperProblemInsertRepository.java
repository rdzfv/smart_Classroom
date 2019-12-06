package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.PaperProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperProblemInsertRepository extends JpaRepository<PaperProblem,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
}
