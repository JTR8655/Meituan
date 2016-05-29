package com.yc.meituan.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.mapper.UserInfoMapper;
import com.yc.meituan.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoMapper.login(userInfo);
	}
	@Override
	public void register(UserInfo userInfo) {
		try {
			userInfoMapper.reg(userInfo);
		} catch (Exception e) {
			throw new RuntimeException("插入失败",e);
		}
	}
}
