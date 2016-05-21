package com.yc.meituan.mapper;

import com.yc.meituan.entity.SellerInfo;
import java.math.BigDecimal;

public interface SellerInfoMapper {
    int deleteByPrimaryKey(BigDecimal sid);

    int insert(SellerInfo record);

    int insertSelective(SellerInfo record);

    SellerInfo selectByPrimaryKey(BigDecimal sid);

    int updateByPrimaryKeySelective(SellerInfo record);

    int updateByPrimaryKey(SellerInfo record);
}