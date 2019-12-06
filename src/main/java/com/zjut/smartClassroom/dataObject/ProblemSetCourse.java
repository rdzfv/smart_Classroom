package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ProblemSetCourse {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int problemSetId;
    private String problemSetName;
    private String problemSetDetail;
    private String problemSetPicUrl;
    private String courseName;
    private String teacherName;
    private int courseId;
}
