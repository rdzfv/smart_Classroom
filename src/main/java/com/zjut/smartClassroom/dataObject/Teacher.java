package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/05 09:34:23
 * @description： Teacher实体类（对应Teacher表）
 * @version:     1.0.0
 */
@Data
@Entity
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacherName;
    private String teacherPassword;
    private Integer teacherSex;
    private String teacherAccount;
    private String teacherPhone;
    private String openid;
    private String sessionKey;
}
