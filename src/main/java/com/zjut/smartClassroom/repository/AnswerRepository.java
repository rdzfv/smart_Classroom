package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Answer;
import com.zjut.smartClassroom.dataObject.Course;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/05 13:00:23
 * @description： AnswerRepository
 * @version:     1.0.0
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}