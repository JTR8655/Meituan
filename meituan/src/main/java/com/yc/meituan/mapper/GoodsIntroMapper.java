package com.yc.meituan.mapper;

import com.yc.meituan.entity.GoodsIntro;
import java.math.BigDecimal;

public interface GoodsIntroMapper {
    int deleteByPrimaryKey(BigDecimal gid);

    int insert(GoodsIntro record);

    int insertSelective(GoodsIntro record);

    GoodsIntro selectByPrimaryKey(BigDecimal gid);

    int updateByPrimaryKeySelective(GoodsIntro record);

    int updateByPrimaryKey(GoodsIntro record);
}