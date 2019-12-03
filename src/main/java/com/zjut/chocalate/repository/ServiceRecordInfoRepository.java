package com.zjut.chocalate.repository;

import com.zjut.chocalate.dataObject.ServiceRecordInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface ServiceRecordInfoRepository extends JpaRepository<ServiceRecordInfo, Integer> {
    ServiceRecordInfo findByServicerecordid(int id);
    List<ServiceRecordInfo> findByDatetimeBetweenAndMemberid(Date pre, Date curr, int id);
}
