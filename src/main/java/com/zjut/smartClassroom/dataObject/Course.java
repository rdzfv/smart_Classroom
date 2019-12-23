package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/05 15:45:23
 * @description：Course实体类（对应Course表）
 * @version:     1.0.0
 */
@Data
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private Integer courseCredit;
    private String courseMethod;
    private String courseDetail; // 课程描述
    private String coursePicUrl; // 课程图标url
    private Integer teacherId;
}
