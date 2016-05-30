package com.yc.meituan.service;

import com.yc.meituan.entity.UserInfo;

public interface UserService {

	UserInfo login(UserInfo userInfo);
	
	void register(UserInfo userInfo);
}
