package com.yc.meituan.service;

import com.yc.meituan.entity.Collections;

public interface CollectionsService {

	void addCollection(Collections collections);

	Collections checkIsCollect(Collections collections);

	void deleteCol(Integer cid);

}
