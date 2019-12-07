package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Integer> {


    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 查询所有题目
    List<Problem> findAll();
}
