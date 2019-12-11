package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: Hefz.
 * @date: 2019/12/11.
 * @description:
 */
@Data
@Entity
public class TeacherCourseInformation implements Serializable {
    @Id
    private Integer teacherId;
    private Integer courseId;
    private String courseName;
    private Integer courseCredit;
    private String courseMethod;
    private String courseDetail;
    private String coursePicUrl;
    private String teacherName;
}
