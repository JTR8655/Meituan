package com.yc.meituan.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.mapper.UserInfoMapper;
import com.yc.meituan.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoMapper.login(userInfo);
	}
	@Override
	public UserInfo register(UserInfo userInfo) {
		try {
			userInfoMapper.reg(userInfo);
			//userInfoMapper.sendEmail(userInfo.getUemail());
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("插入失败",e);
		}
	}
	
	
	@Override
	public UserInfo findEmail(String uemail) {
		return userInfoMapper.findEmail(uemail);
	}
	@Override
	public UserInfo activeUser(String uemail) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
