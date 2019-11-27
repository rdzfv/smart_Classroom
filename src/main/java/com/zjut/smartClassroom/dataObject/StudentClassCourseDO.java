package com.zjut.smartClassroom.dataObject;

public class StudentClassCourseDO {
    private Integer courStuId;

    private Integer studentId;

    private Integer teacherId;

    private Integer courseId;

    public Integer getCourStuId() {
        return courStuId;
    }

    public void setCourStuId(Integer courStuId) {
        this.courStuId = courStuId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}