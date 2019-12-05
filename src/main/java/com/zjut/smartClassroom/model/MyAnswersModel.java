package com.zjut.smartClassroom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/05 11:03:23
 * @description： MyAnswersModel模型
 * @version:     1.0.0
 */
@Data
@Entity
public class MyAnswersModel {
    @Id
    private Integer studentId;
    private String studentAccount;
    private Integer courseId;
    private Integer problemSetId;
    private String myAnswers;
}
