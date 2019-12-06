package com.zjut.smartClassroom.dataObject;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProblemSetPart {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Id
    private int problemSetId;
    private String problemSetName;
    private String problemSetDetail;
    private String problemSetPicUrl;

    // 当前问题：1.前端可能与后端差11个小时；2.如果前端无法更改那么可能是下面那个AOP插入有问题，到时候再解决
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date problemReleaseTime;
    private int paperId;
}
