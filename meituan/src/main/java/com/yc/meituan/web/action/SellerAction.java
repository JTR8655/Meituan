package com.yc.meituan.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.service.SellerService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("sellerAction")
public class SellerAction implements ModelDriven<SellerInfo>, SessionAware, RequestAware {
	private Map<String, Object> session;
	private Map<String, Object> request;
	private SellerInfo sellerInfo;
	private GoodsInfo goodsInfo;

	@Autowired
	SellerService sellerService;

	public String login() {
		LogManager.getLogger().debug(sellerInfo);
		SellerInfo seller = sellerService.login(sellerInfo);
		if (null != seller) {
			session.put(MeituanData.LOGIN_SELLER, seller);
			AjaxUtil.stringAjaxResponse("1");
			return "none";
		} else {
			session.put(MeituanData.ERROR_MSG, "登陆失败！用户名或密码错误");
			AjaxUtil.stringAjaxResponse("0");
			return "none";
		}
	}

	public String SBackShowGoods() {
		List<GoodsInfo> SBgoods = sellerService.SBShowGoods(goodsInfo.getSid());
		LogManager.getLogger().debug("商家后台取到的数据" + SBgoods);
		AjaxUtil.objectAjaxResponse(SBgoods);
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
	public SellerInfo getModel() {
		sellerInfo = new SellerInfo();
		return sellerInfo;
	}

}
