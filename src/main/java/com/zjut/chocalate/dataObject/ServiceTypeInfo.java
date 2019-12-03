package com.zjut.chocalate.dataObject;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Component
public class ServiceTypeInfo implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer serviceid;
    private String title;
    private String detail;
    private double price;

//    @OneToMany(mappedBy="serviceTypeInfo")
//    private Set<ServiceRecordInfo> serviceRecordInfos = new HashSet<>();

}
