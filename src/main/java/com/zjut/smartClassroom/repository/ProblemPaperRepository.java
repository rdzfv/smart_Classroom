package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:28:23
 * @description：StudentRepository
 * @version:     1.0.0
 */
public interface ProblemPaperRepository extends JpaRepository<ProblemPaper, ProblemPaper> {
    List<ProblemPaper> findAllByPaperId(int paperId);
}