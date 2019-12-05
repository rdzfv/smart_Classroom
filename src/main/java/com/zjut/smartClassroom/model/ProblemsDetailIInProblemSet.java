package com.zjut.smartClassroom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/05 9:16:04
 * @description： ProblemsDetailIInProblemSet模型
 * @version:     1.0.0
 */
@Data
@Entity
public class ProblemsDetailIInProblemSet {
    @Id
    private int problemId;
    private String problemInfo;
    private int problemAns;
    private String problemExplain;
    private String problemChoose1;
    private String problemChoose2;
    private String problemChoose3;
    private String problemChoose4;
    private String fatherCourseName;
    private String fatherCourseTeacher;
    private String fatherProblemSetName;
}
