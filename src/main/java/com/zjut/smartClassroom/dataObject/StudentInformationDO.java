package com.zjut.smartClassroom.dataObject;

public class StudentInformationDO {
    private Integer studentId;

    private String personCharacteristic;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getPersonCharacteristic() {
        return personCharacteristic;
    }

    public void setPersonCharacteristic(String personCharacteristic) {
        this.personCharacteristic = personCharacteristic == null ? null : personCharacteristic.trim();
    }
}