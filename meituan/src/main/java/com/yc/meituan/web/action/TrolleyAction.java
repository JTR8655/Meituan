package com.yc.meituan.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.Trolley;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.TrolleySerevice;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("trolleyAction")
public class TrolleyAction implements SessionAware, RequestAware, ModelDriven<Trolley> {

	private Trolley trolley;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Autowired
	TrolleySerevice trolleyserice;
	
	public String addToGoodsCar(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			AjaxUtil.stringAjaxResponse(""+2);
			return "none";
		}
		trolley.setMuid(user.getMuid());
		try {
			trolleyserice.addToGoodsCar(trolley);
			AjaxUtil.stringAjaxResponse(""+1);
		} catch (Exception e) {
			AjaxUtil.stringAjaxResponse(""+0);
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
	public Trolley getModel() {
		trolley = new Trolley();
		return trolley;
	}

}
