package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

@Service
public interface WechatService {
    // 校验请求的真实性
    String checkRequect(String openId, String formId) throws BusinessException;
}
