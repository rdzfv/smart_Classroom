package com.zjut.smartClassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zjut.smartClassroom.dataObject.Paper;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.repository
 * @ClassName: PaperRepository
 * @Author: FrankWu
 * @Description: ${description}
 * @Date: 2019/12/7 13:00
 * @Version: 1.0
 */
public interface PaperRepository extends JpaRepository<Paper, Integer> {
    Paper findByPaperId(Integer paperId);
}
