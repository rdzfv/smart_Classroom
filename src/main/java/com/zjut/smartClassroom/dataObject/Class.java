package com.zjut.smartClassroom.dataObject;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/05 12:45:23
 * @description：Class实体类（对应class表）
 * @version:     1.0.0
 */
@Data
@Entity
@IdClass(ClassPK.class)
public class Class implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private Integer teacherId;
    private Integer courseId;
    private String classClassroom;
    private String className;
    private Integer classOpenyear;
}
