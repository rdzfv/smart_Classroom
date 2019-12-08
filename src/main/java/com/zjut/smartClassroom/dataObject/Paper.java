package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Paper {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int paperId;
    private String paperName;
}
