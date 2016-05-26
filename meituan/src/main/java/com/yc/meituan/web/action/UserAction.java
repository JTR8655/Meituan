package com.yc.meituan.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.UserService;
import com.yc.meituan.util.VoteData;

@Controller("userAction")
public class UserAction implements ModelDriven<UserInfo>, SessionAware, RequestAware{
	
	@Autowired
	private UserService userService;
	
	private UserInfo userInfo;
	private Map<String, Object> session;
	private Map<String, Object> request;

	//登录
	public String login(){
		LogManager.getLogger().debug("userInfo:" + userInfo);
		UserInfo user = userService.login(userInfo);
		if(null != user){
			session.put(VoteData.LOGIN_USER, user);
			return "loginSuccess";
		}else{
			session.put(VoteData.ERROR_MSG, "登陆失败！用户名或密码错误");
			return "login";
		}
	}
	
	//注销登录
	public String logout(){
		int code = 0;
		if(session.get(VoteData.LOGIN_USER) != null){
			session.remove(VoteData.LOGIN_USER);
			code = 1;
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(code+"");//写出响应数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "none";
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
