package com.yc.meituan.web.action;

import java.io.File;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.opensymphony.xwork2.ActionContext;

public class RegisterMailAction {
	private static final String MimeMessage = null;
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmail(){

		MimeMessage mm=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm=new MimeMessageHelper(mm,true);
			smm.setFrom("studymail_test@163.com");//邮件发送者
			smm.setTo("918811028@qq.com");//邮件接收者
			smm.setSubject("激活用户"); //邮件主题
			String activeId=UUID.randomUUID().toString();
			String activePath="http://localhost:8080/vote_ssm/user_active.action?activeId="+activeId;
			smm.setText("<html><body><a href='"+activePath+"'>"+activePath+"</a></body></html>", true); //邮件内容
		//	FileSystemResource res = new FileSystemResource(new File("d:/19.jpg"));
		//	smm.addInline("identifier1234", res);
			javaMailSender.send(mm);//发送邮件
			ActionContext.getContext().getSession().put("activeId", activeId);
			return "success";
		} catch (MessagingException e) {
		}
		return "fail";
		
	}
}