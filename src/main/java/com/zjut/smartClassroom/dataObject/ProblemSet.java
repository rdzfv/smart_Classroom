package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/04 23:09:23
 * @description：problemSet实体类（对应problemSet表）
 * @version:     1.0.0
 */
@Data
@Entity
public class ProblemSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer problemSetId;
    private Integer teacherId;
    private Integer courseId;
    private Timestamp problemReleaseTime;
    private Integer paperId;
    private String problemSetName;
}
