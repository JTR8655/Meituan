package com.yc.meituan.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.service.GoodsService;
import com.yc.meituan.service.ShowGoodsService;
import com.yc.meituan.util.AjaxUtil;

public class GoodsAction implements ModelDriven<GoodsBean>, SessionAware, RequestAware {

	private GoodsBean goodsBean;
	private Map<String, Object> session;
	private Map<String, Object> request;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ShowGoodsService showGoodsService;

	public String indexGoods(){
		List<GoodsInfo> goodsInfos = goodsService.listGoodsInIndex();
		AjaxUtil.objectAjaxResponse(goodsInfos);
		return "none";
	}
	
	//显示商品详情
	public String showGoods(){
		LogManager.getLogger().debug(goodsBean.getGid());
		List<GoodsBean> goodsbeans = showGoodsService.listShowGoods(goodsBean.getGid());
		AjaxUtil.objectAjaxResponse(goodsbeans);
		return "none";
	}
	//显示商品介绍
	public String showGoodsIntro(){
		List<GoodsBean> goodsIntro= showGoodsService.listShowGoodsIntro(goodsBean.getGid());
		AjaxUtil.objectAjaxResponse(goodsIntro);
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
	public GoodsBean getModel() {
		goodsBean = new GoodsBean();
		return goodsBean;
	}

	

	
}
