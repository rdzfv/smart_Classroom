package com.zjut.chocalate.Service.impl;

import com.zjut.chocalate.Service.ServService;
import com.zjut.chocalate.dataObject.ServiceRecordInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.repository.ServiceRecordInfoRepository;
import com.zjut.chocalate.repository.ServiceTypeInfoRepository;
import com.zjut.chocalate.repository.UserLoginInfoRepository;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ServServiceImpl implements ServService {
    @Autowired(required = false) // 引入
    private ServiceRecordInfoRepository serviceRecordInfoRepository;
    @Autowired(required = false) // 引入
    private ServiceTypeInfoRepository serviceTypeInfoRepository;
    @Autowired(required = false) // 引入
    private UserLoginInfoRepository userLoginInfoRepository;
    @Autowired(required = false) // 引入
    private ServiceRecordInfo serviceRecordInfoInstance;

    @Override
    @Transactional
    public ServiceRecordInfo addServiceRecord(ServiceRecordInfo serviceRecordInfo) throws BusinessException {
        if (!serviceTypeInfoRepository.existsById(serviceRecordInfo.getTypeid()) ||
                !userLoginInfoRepository.existsById(serviceRecordInfo.getStaffid()))
            throw new BusinessException(EnumBusinessError.ADD_FAILED);
        // 添加操作
        serviceRecordInfoInstance = serviceRecordInfoRepository.save(serviceRecordInfo);
        return serviceRecordInfoInstance;
    }

    @Override
    @Transactional
    public ServiceRecordInfo updateServiceRecord(ServiceRecordInfo serviceRecordInfo) throws BusinessException {
        System.out.println("serviceImpl:" + serviceRecordInfo.getServicerecordid());
        // 判断要更新的记录Id是否存在
        if (!serviceRecordInfoRepository.existsById(serviceRecordInfo.getServicerecordid()))
            throw new BusinessException(EnumBusinessError.UPDATE_FAILED);
        // 判断待更新的数据是否存在外间关联失败
        if (!serviceTypeInfoRepository.existsById(serviceRecordInfo.getTypeid()) ||
                !userLoginInfoRepository.existsById(serviceRecordInfo.getStaffid()))
            throw new BusinessException(EnumBusinessError.UPDATE_FAILED);
        // 更新操作
        serviceRecordInfoInstance = serviceRecordInfoRepository.save(serviceRecordInfo);
        return serviceRecordInfoInstance;
    }

    @Override
    @Transactional
    public ServiceRecordInfo findServiceRecordById(int id) throws BusinessException {
        // 查询操作
        serviceRecordInfoInstance = serviceRecordInfoRepository.findByServicerecordid(id);
        return serviceRecordInfoInstance;
    }

    @Override
    @Transactional
    public ServiceRecordInfo deleteServiceRecordById(int id) throws BusinessException {
        // 判断要删除的记录Id是否存在
        if (!serviceRecordInfoRepository.existsById(id)) throw new BusinessException(EnumBusinessError.DELETE_FAILED);
        // 删除操作
        serviceRecordInfoRepository.deleteById(id);
        return serviceRecordInfoInstance;
    }

    @Override
    public List<ServiceRecordInfo> findWeeklyServiceRecordsByMemberId(int id) throws BusinessException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统时间
        Date currentTime = new Date();
        java.sql.Date currentTimeResult = null;
        try {
            currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format.format(currentTime));
            currentTimeResult = new java.sql.Date(currentTime.getTime());
        } catch (Exception e) {
            System.out.println(e);
        }
        // 计算一周前的时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -6);
        Date weekAgo = calendar.getTime();
        java.sql.Date preTimeResult = null;
        try {
            weekAgo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format.format(weekAgo));
            preTimeResult = new java.sql.Date(weekAgo.getTime());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(preTimeResult + " "+ currentTimeResult + " " + id);
        List<ServiceRecordInfo> serviceRecordInfos = null;
        try {
             serviceRecordInfos = serviceRecordInfoRepository.findByDatetimeBetweenAndMemberid(preTimeResult, currentTimeResult, id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return serviceRecordInfos;
    }
}
