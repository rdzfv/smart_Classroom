package com.zjut.smartClassroom.dataObject;

import java.util.Date;

public class ProblemSetDO {
    private Integer problemSetId;

    private Integer teacherId;

    private Integer courseId;

    private Date problemReleaseTime;

    private Integer paperId;

    private String problemSetName;

    private String problemSetDetail;

    private String problemSetPicurl;

    public Integer getProblemSetId() {
        return problemSetId;
    }

    public void setProblemSetId(Integer problemSetId) {
        this.problemSetId = problemSetId;
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

    public Date getProblemReleaseTime() {
        return problemReleaseTime;
    }

    public void setProblemReleaseTime(Date problemReleaseTime) {
        this.problemReleaseTime = problemReleaseTime;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getProblemSetName() {
        return problemSetName;
    }

    public void setProblemSetName(String problemSetName) {
        this.problemSetName = problemSetName == null ? null : problemSetName.trim();
    }

    public String getProblemSetDetail() {
        return problemSetDetail;
    }

    public void setProblemSetDetail(String problemSetDetail) {
        this.problemSetDetail = problemSetDetail == null ? null : problemSetDetail.trim();
    }

    public String getProblemSetPicurl() {
        return problemSetPicurl;
    }

    public void setProblemSetPicurl(String problemSetPicurl) {
        this.problemSetPicurl = problemSetPicurl == null ? null : problemSetPicurl.trim();
    }
}