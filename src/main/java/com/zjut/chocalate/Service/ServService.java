package com.zjut.chocalate.Service;

import com.zjut.chocalate.dataObject.ServiceRecordInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.error.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServService {
    ServiceRecordInfo addServiceRecord(ServiceRecordInfo serviceRecordInfo) throws BusinessException;
    ServiceRecordInfo updateServiceRecord(ServiceRecordInfo serviceRecordInfo) throws BusinessException;
    ServiceRecordInfo findServiceRecordById(int id) throws BusinessException;
    ServiceRecordInfo deleteServiceRecordById(int id) throws BusinessException;
    List<ServiceRecordInfo> findWeeklyServiceRecordsByMemberId(int id) throws BusinessException;
}
