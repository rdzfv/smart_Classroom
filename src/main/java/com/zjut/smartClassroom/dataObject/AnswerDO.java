package com.zjut.smartClassroom.dataObject;

public class AnswerDO {
    private Integer ansId;

    private Integer studentId;

    private Integer problemSetId;

    private Integer problemId;

    private Byte studentAns;

    private Byte istrue;

    private Byte rightAns;

    public Integer getAnsId() {
        return ansId;
    }

    public void setAnsId(Integer ansId) {
        this.ansId = ansId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getProblemSetId() {
        return problemSetId;
    }

    public void setProblemSetId(Integer problemSetId) {
        this.problemSetId = problemSetId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Byte getStudentAns() {
        return studentAns;
    }

    public void setStudentAns(Byte studentAns) {
        this.studentAns = studentAns;
    }

    public Byte getIstrue() {
        return istrue;
    }

    public void setIstrue(Byte istrue) {
        this.istrue = istrue;
    }

    public Byte getRightAns() {
        return rightAns;
    }

    public void setRightAns(Byte rightAns) {
        this.rightAns = rightAns;
    }
}