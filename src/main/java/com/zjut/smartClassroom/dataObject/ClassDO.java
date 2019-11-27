package com.zjut.smartClassroom.dataObject;

public class ClassDO extends ClassDOKey {
    private String classClassroom;

    private String className;

    private Integer classOpenyear;

    public String getClassClassroom() {
        return classClassroom;
    }

    public void setClassClassroom(String classClassroom) {
        this.classClassroom = classClassroom == null ? null : classClassroom.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getClassOpenyear() {
        return classOpenyear;
    }

    public void setClassOpenyear(Integer classOpenyear) {
        this.classOpenyear = classOpenyear;
    }
}