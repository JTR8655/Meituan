package meituan.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

//import ui.FindPassword1;


public class SendEmailUtil {

	private String eserverhost="";
	private String emailname="";
	private String emailpwd="";
	private static MimeMessage message;
	private Session session;
	private static Properties properties = new Properties();
	private Transport transport;
	public static boolean flag;
	
	public SendEmailUtil(boolean debug){
		eserverhost = properties.getProperty("smtp.163.com");
		emailname = properties.getProperty("13298581430@163.com");
        emailpwd = properties.getProperty("qwe123123");
        properties.put("mail.smtp.host","smtp.163.com");
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties,null);
        session.setDebug(debug);// 开启后有调试信息
        message = new MimeMessage(session);
	}
	
	public String send(String content,String receiver,File file){
		String yzm="";
		Random r=new Random();
		for(int i=0;i<6;i++){
			yzm+=r.nextInt(10);
		}
		
		try {
			// 发件人
			InternetAddress from = new InternetAddress("13298581430@163.com");
			message.setFrom(from);
			
			// 收件人
			InternetAddress to = new InternetAddress(receiver);
			message.setRecipient(Message.RecipientType.TO, to);
			
			// 邮件主题
			message.setSubject("验证帐号");
			
			// 向reciever对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
			
			// 添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(content, "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);
			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();
			transport = session.getTransport("smtp");
			// smtp验证，就是你用来发邮件的邮箱用户名密码
			transport.connect("SMTP.163.com", "13298581430@163.com", "nlbgikphduvkibwz");
			// 发送
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("邮件发送成功!");
			System.out.println(yzm);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();			
			flag=false;
			System.out.println("错误");
		} finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
		return yzm;
	}

}
