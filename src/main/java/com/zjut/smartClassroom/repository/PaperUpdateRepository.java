package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaperUpdateRepository extends JpaRepository<Paper,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 根据试卷id更改试卷概要
    @Modifying
    @Transactional
    @Query("update  Paper p set p.paperName=?1 where p.paperId=?2")
    int updateDataByPaperId(String paperName,int paperId);
}
