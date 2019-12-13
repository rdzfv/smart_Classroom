package com.zjut.smartClassroom.view;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.view
 * @ClassName: StuClassPK
 * @Author: FrankWu
 * @Description: 学生选课复合主键
 * @Date: 2019/12/13 20:17
 * @Version: 1.0
 */

@Data
public class StuClassPK implements Serializable {
    private Integer studentId;
    private Integer teacherId;
    private Integer courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StuClassPK)) return false;
        StuClassPK that = (StuClassPK) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getTeacherId(), that.getTeacherId()) &&
                Objects.equals(getCourseId(), that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getTeacherId(), getCourseId());
    }
}
