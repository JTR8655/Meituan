package com.yc.meituan.mapper;

import com.yc.meituan.entity.Trolley;
import java.math.BigDecimal;

public interface TrolleyMapper {
    int deleteByPrimaryKey(BigDecimal tid);

    int insert(Trolley record);

    int insertSelective(Trolley record);

    Trolley selectByPrimaryKey(BigDecimal tid);

    int updateByPrimaryKeySelective(Trolley record);

    int updateByPrimaryKey(Trolley record);
}