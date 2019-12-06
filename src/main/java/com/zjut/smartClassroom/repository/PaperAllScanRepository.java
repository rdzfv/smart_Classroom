package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperAllScanRepository extends JpaRepository<Paper,Integer> {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 查询所有试卷概要
    List<Paper> findAll();
}
