package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description: class_information view
 */

@Data
@Entity
public class ClassInformation implements Serializable{
    @Id
    private Integer classId;
    private Integer pptId;
    private String pptName;
    private String pptUrl;
    private String courseName;
    private String teacherName;

}
