package com.zjut.chocalate.dataObject;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

import java.time.format.DateTimeFormatter;
import java.util.Date;


@Data
@Entity
@Component
public class ServiceRecordInfo implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer servicerecordid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    private Integer typeid;
    private String comments;
    private Integer staffid;
    private Integer memberid;

//    @ManyToOne(targetEntity=ServiceRecordInfo.class)
//    @JoinColumn(name="serviceid")
//    private ServiceTypeInfo serviceTypeInfo;
}


