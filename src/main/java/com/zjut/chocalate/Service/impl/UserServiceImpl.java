package com.zjut.chocalate.Service.impl;

import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.repository.MemberInfoRepository;
import com.zjut.chocalate.repository.UserLoginInfoRepository;
import com.zjut.chocalate.Service.*;
import com.zjut.chocalate.dataObject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//引入
    private UserLoginInfoRepository userLoginInfoRepository;
    @Autowired(required = false)//引入
    private MemberInfoRepository memberInfoRepository;
    @Autowired(required = false)//引入
    private UserLoginInfo userLoginInfoResult;
    @Autowired(required = false)//引入
    private MemberInfo memberInfoResult;

    @Override
    @Transactional
    public UserLoginInfo login(UserLoginInfo userLoginInfo) throws BusinessException {
        // 验证用户身份信息是否合法
        userLoginInfoResult = userLoginInfoRepository.findByUsernameAndPasswordAndType(
                userLoginInfo.getUsername(), userLoginInfo.getPassword(), userLoginInfo.getType()
        );
        // 如果用户身份不合法，抛出用户不合法异常
        if (userLoginInfoResult == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return userLoginInfoResult;
    }

    @Override
    @Transactional
    public MemberInfo findMemberInfoById(int id) throws BusinessException{
        memberInfoResult = memberInfoRepository.findByMemberid(id);
        if (memberInfoResult.getAccount() < 0) throw new BusinessException(EnumBusinessError.USER_ACCOUNT_ISARREARAGE);
        return memberInfoResult;
    }
}
