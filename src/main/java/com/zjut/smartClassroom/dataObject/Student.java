package com.zjut.smartClassroom.dataObject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：Student实体类（对应student表）
 * @version:     1.0.0
 */
@Data
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private String studentPassword;
    private Integer studentSex;
    private String studentAccount;
    private String openId;
    private String sessionKey;
}