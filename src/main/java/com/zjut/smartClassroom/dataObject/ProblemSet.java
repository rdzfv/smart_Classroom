package com.zjut.smartClassroom.dataObject;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProblemSet {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */
    @Id
    private int problemSetId;
    private int teacherId;
    private int courseId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date problemReleaseTime;
    private int paperId;
    private String problemSetName;
    private String problemSetDetail;
    private String problemSetPicUrl;
}
