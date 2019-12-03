package com.zjut.chocalate.Service.impl;

import com.zjut.chocalate.Service.ServiceTypeService;
import com.zjut.chocalate.Service.UserService;
import com.zjut.chocalate.dataObject.MemberInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.repository.MemberInfoRepository;
import com.zjut.chocalate.repository.ServiceTypeInfoRepository;
import com.zjut.chocalate.repository.UserLoginInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired(required = false)//引入
    private ServiceTypeInfoRepository serviceTypeInfoRepository;
    @Autowired(required = false)//引入
    private ServiceTypeInfo serviceTypeInfoInstance;

    @Override
    @Transactional
    public ServiceTypeInfo addServiceType(ServiceTypeInfo serviceTypeInfo) throws BusinessException {
        serviceTypeInfoInstance = serviceTypeInfoRepository.save(serviceTypeInfo);
        return serviceTypeInfoInstance;
    }

    @Override
    @Transactional
    public ServiceTypeInfo updateServiceType(ServiceTypeInfo serviceTypeInfo) throws BusinessException {
        serviceTypeInfoInstance = serviceTypeInfoRepository.save(serviceTypeInfo);
        return serviceTypeInfoInstance;
    }

    @Override
    @Transactional
    public ServiceTypeInfo findServiceTypeById(int id) throws BusinessException {
        serviceTypeInfoInstance = serviceTypeInfoRepository.findByServiceid(id);
        return serviceTypeInfoInstance;
    }

    @Override
    @Transactional
    public ServiceTypeInfo deleteServiceTypeById(int id) throws BusinessException {
        if (!serviceTypeInfoRepository.existsById(id)) throw new BusinessException(EnumBusinessError.DELETE_FAILED);
        serviceTypeInfoRepository.deleteById(id);
        return serviceTypeInfoInstance;
    }
}
