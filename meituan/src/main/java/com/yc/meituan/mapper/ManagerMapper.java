package com.yc.meituan.mapper;

import com.yc.meituan.entity.Manager;
import java.math.BigDecimal;

public interface ManagerMapper {
    int deleteByPrimaryKey(BigDecimal mid);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(BigDecimal mid);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}