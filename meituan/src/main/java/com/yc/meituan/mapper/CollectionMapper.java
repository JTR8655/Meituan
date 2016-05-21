package com.yc.meituan.mapper;

import com.yc.meituan.entity.Collections;
import java.math.BigDecimal;

public interface CollectionMapper {
    int deleteByPrimaryKey(BigDecimal cid);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(BigDecimal cid);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}