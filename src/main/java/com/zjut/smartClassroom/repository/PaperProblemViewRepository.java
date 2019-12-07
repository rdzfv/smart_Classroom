package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.PaperProblemView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperProblemViewRepository extends JpaRepository<PaperProblemView,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    // 根据paperId查询试卷整体
    @Query("select p from PaperProblemView p where p.paperId = ?1")
    List<PaperProblemView> findAllByPaperId(Integer paperId);
}
