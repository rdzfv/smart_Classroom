package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/03 12:45:23
 * @description： Answer实体(对应answer表)
 * @version:     1.0.0
 */
@Data
@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansId;
    private Integer studentId;
    private Integer problemSetId;
    private Integer problemId;
    private Integer studentAns;
    private Integer isTrue;
}
