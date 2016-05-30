package com.yc.meituan.service.impl;


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

}
