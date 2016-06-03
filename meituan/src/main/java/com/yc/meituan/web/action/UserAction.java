package com.yc.meituan.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.UserService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("userAction")
public class UserAction implements ModelDriven<UserInfo>, SessionAware, RequestAware {

	@Autowired
	private UserService userService;
	@Autowired
	private JavaMailSender javaMailSender;

	private UserInfo userInfo;
	private Map<String, Object> session;
	private Map<String, Object> request;

	private String province;
	private String city;
	private String uemail;

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// 登录
	public String login() {
		LogManager.getLogger().debug("userInfo:" + userInfo);
		UserInfo user = userService.login(userInfo);
		LogManager.getLogger().debug("取到的用户：" + user);
		if (null != user) {
			session.put(MeituanData.LOGIN_USER, user);
			return "loginSuccess";
		} else {
			session.put(MeituanData.ERROR_MSG, "登陆失败！用户名或密码错误");
			return "login";
		}
	}

	// 注销登录
	public String logout() {
		int code = 0;
		if (session.get(MeituanData.LOGIN_USER) != null) {
			session.remove(MeituanData.LOGIN_USER);
		}

		AjaxUtil.stringAjaxResponse(code + "");
		LogManager.getLogger().debug("注销成功");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(code + "");// 写出响应数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "none";
	}

	public String findEmail() {
		LogManager.getLogger().debug("" + userInfo.getUemail());
		// UserInfo userInfos=userService.findEmail(userInfo.getUemail());
		UserInfo uemail = userService.findEmail(userInfo.getUemail());
		LogManager.getLogger().debug(uemail);
		int status = 0;
		if (uemail != null) {
			if (uemail.getUemail() != null && "".equals(uemail.getUemail())) {
				// 存在
				status = 0;
			}
		} else {
			status = 1;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(status + "");// 写出响应数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "none";
	}

	public String register() {
		LogManager.getLogger().debug("注册操作+" + userInfo);
		userInfo.setUaddr(province + "-" + city);
		try {
			userInfo = userService.register(userInfo);
			session.put("userInfo", userInfo);
			// 调用发邮件方法
			boolean flag = sendEmail(userInfo.getUemail());
			LogManager.getLogger().debug(flag);
			if (flag) {
				return "registerSuccess";
			}
		} catch (Exception e) {

		}
		// session.put("regMsg", "该用户已被注册");
		return "register";
	}

	public boolean sendEmail(String toEmail) {
		MimeMessage mm = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper smm = new MimeMessageHelper(mm, true);
			smm.setFrom("13298581430@163.com");// 邮件发送者
			smm.setTo(toEmail);// 邮件接收者
			smm.setSubject("美团用户邮箱验证"); // 邮件主
			smm.setText("<p>Hi~</p>" + "<p><a href='http://localhost:8080/meituan/user_actives.action?uemail="
					+ toEmail 
					+ "'>感谢您注册,请点击此链接激活您的账号</a></p>", true); // 邮件内容
			javaMailSender.send(mm);// 发送邮件
			return true;
		} catch (MessagingException e) {
		}
		return false;
	}

	public String actives() {
		LogManager.getLogger().debug("取到的数据："+uemail);
		try {
			userService.activeUser(uemail);
			return "activeSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "activeFail";
		}
	}

	public String code() throws IOException {
		// 设置响应头 Content-type类型
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("image/jpeg");
		// 以下三句是用于设置页面不缓存
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "No-cache");
		resp.setDateHeader("Expires", 0);
		OutputStream os = resp.getOutputStream();

		int width = 83, height = 30;
		// 建立指定宽、高和BufferedImage对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics(); // 该画笔画在image上
		Color c = g.getColor(); // 保存当前画笔的颜色，用完画笔后要回复现场
		g.fillRect(0, 0, width, height);

		char[] ch = "1234567890".toCharArray(); // 随即产生的字符串 不包括 i l(小写L) o（小写O）
												// 1（数字1）0(数字0)
												// abcdefghjkmnpqrstuvwxyz
		int length = ch.length; // 随即字符串的长度
		String sRand = ""; // 保存随即产生的字符串
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			// 设置字体
			g.setFont(getFont());
			// 随即生成0-9的数字
			String rand = new Character(ch[random.nextInt(length)]).toString();
			sRand += rand;
			// 设置随机颜色
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			g.drawString(rand, 20 * i + 6, 25);
		}
		// 产生随即干扰点
		for (int i = 0; i < 20; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		g.setColor(c); // 将画笔的颜色再设置回去
		g.dispose();

		// 将验证码记录到session
		request.getSession().setAttribute("code", sRand);
		// 输出图像到页面
		try {
			ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "none";
	}

	private Font getFont() {
		Random random = new Random();
		Font font[] = new Font[5];
		font[0] = new Font("Ravie", Font.PLAIN, 24);
		font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);
		font[2] = new Font("Forte", Font.PLAIN, 24);
		font[3] = new Font("Wide Latin", Font.PLAIN, 24);
		font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
		return font[random.nextInt(5)];
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public UserInfo getModel() {
		userInfo = new UserInfo();
		return userInfo;
	}
}
