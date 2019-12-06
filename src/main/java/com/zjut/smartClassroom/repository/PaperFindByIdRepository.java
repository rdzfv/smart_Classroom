package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperFindByIdRepository extends JpaRepository<Paper,Integer> {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    // 根据paperId寻找试卷概要
    Paper findByPaperId(Integer paperId);
}
