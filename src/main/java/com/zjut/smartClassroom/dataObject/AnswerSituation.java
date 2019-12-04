package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AnswerSituation implements Serializable {
    @Id
    private int problemId;
    private String problemInfo;
    private String problemChoose1;
    private String problemChoose2;
    private String problemChoose3;
    private String problemChoose4;
    private int problemAns;
    private String problemExplain;
    private String fatherCourseName;
    private String fatherTeacherName;
    private String fatherProblemSetId;
    private int studentAns1;
    private int studentAns2;
    private int studentAns3;
    private int studentAns4;
}
