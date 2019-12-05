package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：problem实体类（对应problem表）
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
}
