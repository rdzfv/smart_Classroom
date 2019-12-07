package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author     ：dzy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description：problem实体类（对应problem表）
 * @version:     1.0.0
 */
@Data
@Entity
public class Problem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer problemId;
    private String problemInfo;
    private Integer problemAns;
    private String problemExplain;
    private String problemChoose1;
    private String problemChoose2;
    private String problemChoose3;
    private String problemChoose4;
}
