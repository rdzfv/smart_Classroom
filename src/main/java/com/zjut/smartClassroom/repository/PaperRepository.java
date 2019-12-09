package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer> {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 查询所有试卷概要
    List<Paper> findAll();
    // 根据paper_id删除paper概要
    int deleteByPaperId(Integer paperId);
    // 根据paperId寻找试卷概要
    Paper findByPaperId(Integer paperId);

    // 根据试卷id更改试卷概要
    @Modifying
    @Transactional
    @Query("update  Paper p set p.paperName = ?1 where p.paperId = ?2")
    int updateDataByPaperId(String paperName, int paperId);
}
