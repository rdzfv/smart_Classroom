package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Teacher {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int teacherId;
    private String teacherName;
    private String teacherPassword;
    private String teacherAccount;
    private int teacherSex;
    private String teacherPhone;
}
