package com.zjut.chocalate.repository;

import com.zjut.chocalate.dataObject.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfo, Integer> {
    // 根据用户名，密码，类别查找账户
    UserLoginInfo findByUsernameAndPasswordAndType(String username, String password, Integer type);
}

