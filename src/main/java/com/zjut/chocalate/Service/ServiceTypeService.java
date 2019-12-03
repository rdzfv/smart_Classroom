package com.zjut.chocalate.Service;

import com.zjut.chocalate.dataObject.MemberInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import com.zjut.chocalate.error.BusinessException;
import org.springframework.stereotype.Service;

@Service
public interface ServiceTypeService {
    ServiceTypeInfo addServiceType(ServiceTypeInfo serviceTypeInfo) throws BusinessException;
    ServiceTypeInfo updateServiceType(ServiceTypeInfo serviceTypeInfo) throws BusinessException;
    ServiceTypeInfo findServiceTypeById(int id) throws BusinessException;
    ServiceTypeInfo deleteServiceTypeById(int id) throws BusinessException;
}
