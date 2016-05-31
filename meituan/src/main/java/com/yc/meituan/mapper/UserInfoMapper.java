package com.yc.meituan.mapper;

import com.yc.meituan.entity.UserInfo;

public interface UserInfoMapper {

	UserInfo login(UserInfo userInfo);
   
	void reg(UserInfo userInfo);
	
	UserInfo findEmail(String uemail);

	UserInfo sendEmail(String uemail);
	
}