package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Problem {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int problemId;
    private String problemInformation;
    private String problemAns;
    private String problemExplain;
}
