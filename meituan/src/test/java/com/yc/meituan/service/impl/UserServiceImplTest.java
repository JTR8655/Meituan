package com.yc.meituan.service.impl;


import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	
	
	@Test
	public void testRegister() {
		UserInfo userInfo=new UserInfo();
		userInfo.setUaccounts("c");
		userInfo.setUpwd("a");
		userInfo.setUemail("89@QQ.COM");
		userInfo.setUaddr("长沙");
		userService.register(userInfo);
	}
	
	@Test
	public void testLogin() {
		UserInfo userInfo=new UserInfo();
		userInfo.setUpwd("a");
		userInfo.setUemail("1059191443@qq.com");
		LogManager.getLogger().debug(userService.login(userInfo));
	}
}
