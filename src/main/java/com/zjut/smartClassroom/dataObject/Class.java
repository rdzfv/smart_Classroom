package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description: create class table
 */
@Data
@Entity
public class Class {
    @Id
    private Integer classId;
    private Integer teacherId;
    private Integer courseId;
    private String classClassroom;
    private String className;
    private String classOpenyear;
}
