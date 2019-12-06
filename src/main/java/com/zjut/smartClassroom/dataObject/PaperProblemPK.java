package com.zjut.smartClassroom.dataObject;

import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
public class PaperProblemPK implements Serializable {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    private int paperId;
    private int problemId;

    public PaperProblemPK() {
    }

    public PaperProblemPK(int paperId, int problemId) {
        this.paperId = paperId;
        this.problemId = problemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperProblemPK)) return false;
        PaperProblemPK that = (PaperProblemPK) o;
        return getPaperId() == that.getPaperId() &&
                getProblemId() == that.getProblemId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaperId(), getProblemId());
    }
}
