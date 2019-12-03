package com.zjut.chocalate.repository;

import com.zjut.chocalate.dataObject.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer> {
    MemberInfo findByMemberid(Integer id);
}
