package com.yc.meituan.service;

import java.util.List;

import com.yc.meituan.entity.Collections;
import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.UorderBean;

public interface UorderService {

	List<UorderBean> showAllUorder(int muid);

	List<CollectionBean> listCollections(Integer muid);

}
