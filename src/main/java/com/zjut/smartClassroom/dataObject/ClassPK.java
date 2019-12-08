package com.zjut.smartClassroom.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Data
public class ClassPK implements Serializable {
    private int teacherId;
    private int courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassPK classPK = (ClassPK) o;
        return teacherId == classPK.teacherId &&
                courseId == classPK.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, courseId);
    }
}
