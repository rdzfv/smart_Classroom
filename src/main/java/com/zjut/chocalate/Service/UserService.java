package com.zjut.chocalate.Service;

import com.zjut.chocalate.dataObject.MemberInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import com.zjut.chocalate.error.BusinessException;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    // 用户登录(账号密码类型验证)
    UserLoginInfo login(UserLoginInfo userLoginInfo) throws BusinessException;
    MemberInfo findMemberInfoById(int id) throws BusinessException;
}
