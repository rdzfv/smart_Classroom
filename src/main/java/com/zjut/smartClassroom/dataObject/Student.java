package com.zjut.smartClassroom.dataObject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Student implements Serializable {
    @Id
    private Integer studentid;
    private String studentname;
    private String studentpassword;
    private Integer studentsex;
    private String studentaccount;
    private String openid;
    private String sessionkey;

}