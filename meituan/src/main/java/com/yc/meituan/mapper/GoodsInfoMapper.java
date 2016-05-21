package com.yc.meituan.mapper;

import com.yc.meituan.entity.GoodsInfo;
import java.math.BigDecimal;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(BigDecimal gid);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(BigDecimal gid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}