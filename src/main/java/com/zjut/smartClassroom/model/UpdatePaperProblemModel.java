package com.zjut.smartClassroom.model;

import com.zjut.smartClassroom.error.BusinessException;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/08 16:12:43
 * @description： UpdatePaperProblemModel模型
 * @version:     1.0.0
 */
@Data
@Entity
public class UpdatePaperProblemModel {
    @Id
    private Integer paperId;
    private Integer problemId;
    private Integer newProblemId;
}
