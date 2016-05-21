package com.yc.meituan.mapper;

import com.yc.meituan.entity.Uorder;
import java.math.BigDecimal;

public interface UorderMapper {
    int deleteByPrimaryKey(BigDecimal oid);

    int insert(Uorder record);

    int insertSelective(Uorder record);

    Uorder selectByPrimaryKey(BigDecimal oid);

    int updateByPrimaryKeySelective(Uorder record);

    int updateByPrimaryKey(Uorder record);
}