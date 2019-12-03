package com.zjut.chocalate.repository;

import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeInfoRepository extends JpaRepository<ServiceTypeInfo, Integer> {
    ServiceTypeInfo findByServiceid(int id);
}
