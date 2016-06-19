package com.yc.meituan.web.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.Collections;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.service.CollectionsService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("collectionAction")
public class CollectionAction implements ModelDriven<Collections>, SessionAware, RequestAware {
	private Collections collections;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Autowired
	CollectionsService collectionsService;
	
	public String addCollection(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			AjaxUtil.stringAjaxResponse(""+2);
			return "none";
		}
		collections.setMuid(user.getMuid());
		LogManager.getLogger().debug(collections);
		try {
			Collections con = collectionsService.checkIsCollect(collections);
			if(null == con){
				collectionsService.addCollection(collections);
				AjaxUtil.stringAjaxResponse(""+1);
			}else{
				AjaxUtil.stringAjaxResponse(""+3);
			}
		} catch (Exception e) {
			AjaxUtil.stringAjaxResponse(""+0);
			e.printStackTrace();
		}
		
		return "none";
	}
	
	public String deleteCol(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			AjaxUtil.stringAjaxResponse(""+2);
			return "none";
		}
		
		try {
			collectionsService.deleteCol(collections.getCid());
			AjaxUtil.stringAjaxResponse(""+1);
			return "none";
		} catch (Exception e) {
			LogManager.getLogger().error(e.getMessage());
			AjaxUtil.stringAjaxResponse(""+0);
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
	public Collections getModel() {
		collections = new Collections();
		return collections;
	}
}
