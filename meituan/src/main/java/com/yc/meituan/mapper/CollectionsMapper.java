package com.yc.meituan.mapper;

import com.yc.meituan.entity.Collections;

public interface CollectionsMapper {

	void addCollection(Collections collections);

	Collections checkIsCollect(Collections collections);
    
}