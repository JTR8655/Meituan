package com.yc.meituan.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.Uorder;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.entity.bean.CollectionBean;
import com.yc.meituan.entity.bean.NoevalBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.service.UorderService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("uorderAction")
public class UorderAction implements ModelDriven<Uorder>, SessionAware, RequestAware {

	@Autowired
	private UorderService uorderService;
	private Uorder uorder;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	public String showAllUorder(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			return "none";
		}
		LogManager.getLogger().debug("显示所有订单,muid = " + user.getMuid());
		List<UorderBean> uorders = uorderService.showAllUorder(user.getMuid());
		if(null != uorders && uorders.size() > 0){
			LogManager.getLogger().debug("取到数据：" + uorders);
			session.put("uorders", uorders);
			AjaxUtil.objectAjaxResponse(uorders);
		}
		return "none";
	}
	
	public String listCollection(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			return "none";
		}
		List<CollectionBean> collections = uorderService.listCollections(user.getMuid());
		if(null != collections && collections.size() > 0){
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        String nowDate = f.format(date);
			for (CollectionBean collectionBean : collections) {
				String endDate = collectionBean.getB_retime().split("至")[1];
				int result = nowDate.compareTo(endDate);
				if(result < 0){
					collectionBean.setGstatus("进行中");
				}else {
					collectionBean.setGstatus("已结束");
				}
			}
			session.put("collections", collections);
			AjaxUtil.objectAjaxResponse(collections);
		}
		return "none";
	}
	
	public String listNoPj(){
		LogManager.getLogger().debug("显示未评价订单");
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			return "none";
		}
		List<NoevalBean> noevalBeans = uorderService.listNoPj(user.getMuid());
		if(null != noevalBeans && noevalBeans.size() > 0){
			LogManager.getLogger().debug("取到数据：" + noevalBeans);
			session.put("uorders", noevalBeans);
			AjaxUtil.objectAjaxResponse(noevalBeans);
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
	public Uorder getModel() {
		uorder = new Uorder();
		return uorder;
	}

}
