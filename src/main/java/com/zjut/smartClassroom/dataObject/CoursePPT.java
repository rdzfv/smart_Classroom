package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.dataObject
 * @ClassName: CoursePPT
 * @Author: FrankWu
 * @Description: 课程ID、PPT_URL、教师ID
 * @Date: 2019/12/7 16:01
 * @Version: 1.0
 */

@Data
@Entity
public class CoursePPT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coursePPT_Id;
    private String pptName;
    private Integer courseId;
    private Integer teacherId;
    private String pptUrl; // ppt的链接
}
