package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Problem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int problemId;
    private String problemInfo;
    private int problemAns;
    private String problemExplain;
    private String problemChoose1;
    private String problemChoose2;
    private String problemChoose3;
    private String problemChoose4;
}
