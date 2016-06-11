package com.yc.meituan.service.impl;


import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	@Autowired
	private JavaMailSender javaMailSender;
	
	
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
	public void testsendEmail() {
		//userService.sendEmail(userInfo.getUemail());
		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);
			smm.setFrom("13298581430@163.com");//邮件发送者
			smm.setTo("918811028@qq.com");//邮件接收者
			smm.setSubject("美团用户邮箱验证"); //邮件主	
			smm.setText("<p>Hi~</p>"
					+"<p><a href='http://localhost:8080/meituan/user_active.action"
					+"'>感谢您注册,请点击此链接激活您的账号</a></p>", true); //邮件内容
			javaMailSender.send(mm);//发送邮件
		} catch (MessagingException e) {
		}
		System.out.println("邮件发送成功03");
	}
	
	@Test
	public void testActiveUser(){
		UserInfo user=new UserInfo();
		user.setUemail("918811028@qq.com");
		userService.activeUser(user.getUemail());
		
	}

}
