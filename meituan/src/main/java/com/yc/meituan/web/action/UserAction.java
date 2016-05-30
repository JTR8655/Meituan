package com.yc.meituan.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.UserService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("userAction")
public class UserAction implements ModelDriven<UserInfo>, SessionAware, RequestAware{
	
	@Autowired
	private UserService userService;
	
	private UserInfo userInfo;
	private Map<String, Object> session;
	private Map<String, Object> request;

	//登录
	public String login(){
		UserInfo user = userService.login(userInfo);
		LogManager.getLogger().debug("取到的用户：" + user);
		if(null != user){
			session.put(MeituanData.LOGIN_USER, user);
			return "loginSuccess";
		}else{
			session.put(MeituanData.ERROR_MSG, "登陆失败！用户名或密码错误");
			return "login";
		}
	}
	
	//注销登录
	public String logout(){
		int code = 0;
		if(session.get(MeituanData.LOGIN_USER) != null){
			session.remove(MeituanData.LOGIN_USER);
			code = 1;
		}

		AjaxUtil.stringAjaxResponse(code + "");
		LogManager.getLogger().debug("注销成功");
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
