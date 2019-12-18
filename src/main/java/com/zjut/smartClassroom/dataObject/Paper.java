package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Paper {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paperId;
    private String paperName;
    private Integer problemSetId;
}
