package com.yc.meituan.mapper;

import com.yc.meituan.entity.Evaluate;
import java.math.BigDecimal;

public interface EvaluateMapper {
    int deleteByPrimaryKey(BigDecimal eid);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(BigDecimal eid);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}