package com.zjut.smartClassroom.dataObject;

import lombok.Data;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:23:45
 * @description：ProblemPaper类（对应ProblemPaper表）
 * @version:     1.0.0
 */
@Data
@Entity
@IdClass(ProblemPaper.class)
public class ProblemPaper implements Serializable {
    @Id
    private Integer problemId;
    @Id
    private Integer paperId;
}


