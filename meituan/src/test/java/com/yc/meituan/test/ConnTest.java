package com.yc.meituan.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnTest {

	@Autowired
	private SqlSessionFactory sqlSessionfactory;
	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	public void test() {
		Connection conn = sqlSessionfactory.openSession().getConnection();
		assertNotNull("数据库连接失败！！！", conn);
		// 修改测试
	}

	@Test
	public void testTime() {
		Random r = new Random();

		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddhhmmss");
		String time = sf.format(d.getTime());
		for (int i = 0; i < 50; i++) {
			String str = r.nextInt(10000) + "";
			while (str.length() != 3) {
				str = r.nextInt(1000) + "";
			}
			LogManager.getLogger().debug(Integer.parseInt(time + str));
			
		}

		/*
		 * String opwd = ""; for (int i = 0; i < 10; i++) { String charOrNum =
		 * r.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字 if
		 * ("char".equalsIgnoreCase(charOrNum)) { int choice = 65; // 取得大写字母
		 * opwd += (char) (choice + r.nextInt(26)); } else if
		 * ("num".equalsIgnoreCase(charOrNum)) { opwd +=
		 * String.valueOf(r.nextInt(10)); } }
		 * LogManager.getLogger().debug(opwd);
		 */
	}

	@Test
	public void testsendEmail() {
		// userService.sendEmail(userInfo.getUemail());
		MimeMessage mm = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm = new MimeMessageHelper(mm, true);
			smm.setFrom("13298581430@163.com");// 邮件发送者
			smm.setTo("918811028@qq.com");// 邮件接收者
			smm.setSubject("美团用户邮箱验证"); // 主
			smm.setText("<p>Hi~</p>" + "<p><a href='http://localhost:8080/meituan/user_active.action"
					+ "'>感谢您注册,请点击此链接激活您的账号</a></p>", true); // 内容
			javaMailSender.send(mm);// 发送邮件
		} catch (MessagingException e) {
		}
		System.out.println("邮件发送成功03");
	}

}
