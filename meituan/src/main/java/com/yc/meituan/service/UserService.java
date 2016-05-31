package com.yc.meituan.service;

import com.yc.meituan.entity.UserInfo;

public interface UserService {

	UserInfo login(UserInfo userInfo);
	
	UserInfo register(UserInfo userInfo);
	
	UserInfo findEmail(String uemail);

	UserInfo activeUser(String uemail);


}
