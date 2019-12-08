package com.zjut.smartClassroom.dataObject;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Hefz.
 * @date: 2019/12/4.
 * @description: create table course
 */

@Data
@Entity
public class Course implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private Integer courseCredit;
    private String courseMethod;
    private String courseDetail;
    private String coursePicUrl;
}