package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.dataObject
 * @ClassName: StudentClass
 * @Author: FrankWu
 * @Description: 学生及教学班对应表
 * @Date: 2019/12/13 19:11
 * @Version: 1.0
 */

@Data
@Entity
public class StudentClass implements Serializable {
    @Id
    private Integer stuClassId;

    private Integer classId;
    private Integer studentId;
    private Integer grade;
}
