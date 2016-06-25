package com.yc.meituan.web.action;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.UorderBean;
import com.yc.meituan.service.GoodsIntroService;
import com.yc.meituan.service.SellerService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;
import com.yc.meituan.web.bean.SellerGoodsBean;

@Controller("sellerAction")
public class SellerAction implements ModelDriven<SellerGoodsBean>, SessionAware, RequestAware {
	private Map<String, Object> session;
	private Map<String, Object> request;
	private SellerInfo sellerInfo;
	private GoodsInfo goodsInfo;
	private SellerGoodsBean sellerGoodsBean;

	@Autowired
	SellerService sellerService;
	@Autowired
	GoodsIntroService goodsIntroService;

	public String login() {
		SellerInfo seller = sellerService.login(sellerGoodsBean);
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

	public String sBackShowGoods() {
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<GoodsInfo> SBgoods = sellerService.SBShowGoods(seller.getSid());
		LogManager.getLogger().debug("商家后台取到的数据" + SBgoods);
		AjaxUtil.objectAjaxResponse(SBgoods);
		return "none";
	}

	// 检查是否登陆
	public String checkLogin() {
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null != seller) {
			AjaxUtil.objectAjaxResponse(seller);
		} else {
			AjaxUtil.stringAjaxResponse("0");
		}
		return "none";
	}

	public String sLogOut() {
		if (session.get(MeituanData.LOGIN_SELLER) != null) {
			session.remove(MeituanData.LOGIN_SELLER);
		}
		AjaxUtil.stringAjaxResponse(1 + "");
		return "none";
	}

	public String sListOrder() {
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		String status = sellerGoodsBean.getOstatus();
		if (status.equals("全部订单")) {
			status = "%%";
		} else if (status.equals("未消费订单")) {
			status = "%未使用%";
		} else if (status.equals("已消费订单")) {
			status = "%已使用%";
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", seller.getSid());
		params.put("status", status);
		LogManager.getLogger().debug(params);
		List<UorderBean> uorders = sellerService.sListOrder(params);
		if (null != uorders) {
			AjaxUtil.objectAjaxResponse(uorders);
		} else {
			AjaxUtil.stringAjaxResponse("0");
		}
		return "none";
	}

	// 商品下架
	public String updateGoodsType() {
		try {
			sellerService.updateGoodsType(sellerGoodsBean.getGid());
			AjaxUtil.stringAjaxResponse("" + 1);
		} catch (Exception e) {
			LogManager.getLogger().error(e.getMessage());
			AjaxUtil.stringAjaxResponse("" + 0);
		}
		return "none";
	}

	// 更新前操作
	public String updateSGoodsInfos() {
		LogManager.getLogger().debug(sellerGoodsBean);
		SellerGoodsBean goodsBean = sellerService.showSGoodsInfos(sellerGoodsBean.getGid());
		session.put("goodsBean", goodsBean);
		AjaxUtil.objectAjaxResponse(goodsBean);
		return "none";
	}

	// 更新操作
	public String doUpdateSGoodsInfos() {
		SellerGoodsBean ss = (SellerGoodsBean) session.get("goodsBean");
		int s = ss.getGid();
		sellerGoodsBean.setGid(s);
		LogManager.getLogger().debug(sellerGoodsBean);
		try {
			if (sellerGoodsBean != null) {
				sellerService.modyfySGoodsInfos(sellerGoodsBean);
				sellerService.modyfySGoodsIntros(sellerGoodsBean);
				AjaxUtil.stringAjaxResponse(1 + "");
			}
		} catch (Exception e) {
			AjaxUtil.stringAjaxResponse(0 + "");
			e.printStackTrace();
		}
		return "none";
	}

	// 显示订单详情
	public String showOrderInfo() {
		List<SellerGoodsBean> orderInfo = sellerService.showOrderInfo(sellerGoodsBean.getOpwd());
		AjaxUtil.objectAjaxResponse(orderInfo);
		return "none";
	}

	// 修改订单状态
	public String useOrder() {
		int result = sellerService.useOrder(sellerGoodsBean.getOpwd());
		AjaxUtil.objectAjaxResponse(result);
		return "none";
	}

	// 显示历史销量
	public String goodsSoldCounts() {
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<GoodsInfo> counts = sellerService.goodsSoldCounts(seller.getSid());
		LogManager.getLogger().debug(counts);
		AjaxUtil.objectAjaxResponse(counts);
		return "none";
	}

	// 显示评论
	public String goodsEvaluates() {
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<EvaluateBean> evaluates = sellerService.goodsEvaluates(seller.getSid());
		LogManager.getLogger().debug(evaluates);
		AjaxUtil.objectAjaxResponse(evaluates);
		return "none";
	}

	public String getTadaySoldBySid(){
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<SellerGoodsBean> sellerGoodsBeans=sellerService.getTotalSoldBySids(seller.getSid());
		LogManager.getLogger().debug("商家今日销量数据："+sellerGoodsBeans);
		AjaxUtil.objectAjaxResponse(sellerGoodsBeans);
		return "none";
	}
	
	//消费高峰期
	public String highUseCount(){
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if (null == seller) {
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<String> times = new ArrayList<String>();
		times.add("08:00:00");
		times.add("10:00:00");
		times.add("12:00:00");
		times.add("14:00:00");
		times.add("16:00:00");
		times.add("18:00:00");
		times.add("20:00:00");
		List<Integer> highUseList = sellerService.highUseCount(seller.getSid(),times);
		AjaxUtil.objectAjaxResponse(highUseList);
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
	public SellerGoodsBean getModel() {
		sellerGoodsBean = new SellerGoodsBean();
		return sellerGoodsBean;
	}

}
