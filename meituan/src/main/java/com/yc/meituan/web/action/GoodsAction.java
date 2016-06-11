package com.yc.meituan.web.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.service.GoodsService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

public class GoodsAction implements ModelDriven<GoodsBean>, SessionAware, RequestAware {

	private GoodsBean goodsBean;
	private EvaluateBean evaluateBean;
	private Map<String, Object> session;
	private Map<String, Object> request;
	@Autowired
	private GoodsService goodsService;

	public String indexGoods(){
		List<GoodsInfo> goodsInfos = goodsService.listGoodsInIndex();
		AjaxUtil.objectAjaxResponse(goodsInfos);
		return "none";
	}
	
	//显示商品详情
	public String showGoods(){
		List<GoodsBean> goodsbeans = goodsService.listShowGoods(goodsBean.getGid());
		LogManager.getLogger().debug(goodsbeans);
		AjaxUtil.objectAjaxResponse(goodsbeans);
		return "none";
	}
	
	//显示商品介绍
	public String showGoodsIntro(){
		List<GoodsBean> goodsIntro= goodsService.listShowGoodsIntro(goodsBean.getGid());
		AjaxUtil.objectAjaxResponse(goodsIntro);
		return "none";
	}

	//显示评分和评论信息
	public String showEvaluate() {
		List<EvaluateBean> evaluates = goodsService.listshowEvaluateBean(evaluateBean.getGid());
		AjaxUtil.objectAjaxResponse(evaluates);
		return "none";
	}
	
	//显示商家其他商品
	public String showOtherGoods(){
		List<GoodsBean> goodsbean = goodsService.showOtherGoods(goodsBean);
		LogManager.getLogger().debug("取到的数据：" + goodsbean);
		AjaxUtil.objectAjaxResponse(goodsbean);
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
