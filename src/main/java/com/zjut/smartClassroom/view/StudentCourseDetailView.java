package com.zjut.smartClassroom.view;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.model
 * @ClassName: StudentCourseDetailView
 * @Author: FrankWu
 * @Description: 存储学生端前端返回的课程细节
 * @Date: 2019/12/13 08:32
 * @Version: 1.0
 */

@Data
@Entity
@IdClass(StuClassPK.class)
public class StudentCourseDetailView implements Serializable {
    @Id
    private Integer studentId;
    private Integer teacherId;
    private Integer courseId;
    private String studentName;
    private String teacherName;
    private String courseName;
    private String coursePicUrl;
}
