package com.zjut.smartClassroom.dataObject;

public class CourseDO {
    private Integer courseId;

    private String courseName;

    private Integer courseCredit;

    private String courseMethod;

    private String coursePicurl;

    private String coursePptUrl;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseMethod() {
        return courseMethod;
    }

    public void setCourseMethod(String courseMethod) {
        this.courseMethod = courseMethod == null ? null : courseMethod.trim();
    }

    public String getCoursePicurl() {
        return coursePicurl;
    }

    public void setCoursePicurl(String coursePicurl) {
        this.coursePicurl = coursePicurl == null ? null : coursePicurl.trim();
    }

    public String getCoursePptUrl() {
        return coursePptUrl;
    }

    public void setCoursePptUrl(String coursePptUrl) {
        this.coursePptUrl = coursePptUrl == null ? null : coursePptUrl.trim();
    }
}