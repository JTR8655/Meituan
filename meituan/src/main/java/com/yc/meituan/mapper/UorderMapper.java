package com.yc.meituan.mapper;

import java.util.List;

import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.UorderBean;

public interface UorderMapper {

	List<UorderBean> showAllUorder(int muid);

	List<CollectionBean> listCollections(Integer muid);
}