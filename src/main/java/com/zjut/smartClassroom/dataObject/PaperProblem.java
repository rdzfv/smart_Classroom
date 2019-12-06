package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@IdClass(PaperProblemPK.class)
public class PaperProblem implements Serializable {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int paperId;
    @Id
    private int problemId;
}
