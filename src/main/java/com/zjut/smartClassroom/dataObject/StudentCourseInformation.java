package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Method
 * @Author Hefz
 * @Version  1.0
 * @Description
 * @Return
 * @Exception
 * @Date 2019/12/11
 * @Time 8:45 PM
 */

@Data
@Entity
public class StudentCourseInformation implements Serializable {
    @Id
    private Integer studentId;
    private Integer courseId;
    private String courseName;
    private Integer courseCredit;
    private String courseMethod;
    private String courseDetail;
    private String coursePicUrl;
    private String teacherName;
}
