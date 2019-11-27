package com.zjut.smartClassroom.dataObject;

public class ProblemDO {
    private Integer problemId;

    private String problemInformation;

    private String problemChoices;

    private String problemExplain;

    private Integer problemAns;

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getProblemInformation() {
        return problemInformation;
    }

    public void setProblemInformation(String problemInformation) {
        this.problemInformation = problemInformation == null ? null : problemInformation.trim();
    }

    public String getProblemChoices() {
        return problemChoices;
    }

    public void setProblemChoices(String problemChoices) {
        this.problemChoices = problemChoices == null ? null : problemChoices.trim();
    }

    public String getProblemExplain() {
        return problemExplain;
    }

    public void setProblemExplain(String problemExplain) {
        this.problemExplain = problemExplain == null ? null : problemExplain.trim();
    }

    public Integer getProblemAns() {
        return problemAns;
    }

    public void setProblemAns(Integer problemAns) {
        this.problemAns = problemAns;
    }
}