package com.yc.meituan.mapper;

import com.yc.meituan.entity.UserInfo;
import java.math.BigDecimal;

public interface UserInfoMapper {
    int deleteByPrimaryKey(BigDecimal muid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(BigDecimal muid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}