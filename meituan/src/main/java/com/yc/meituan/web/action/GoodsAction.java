package com.yc.meituan.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.GoodsInfo;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.service.GoodsService;
import com.yc.meituan.service.ShowGoodsService;

public class GoodsAction implements ModelDriven<GoodsBean>, SessionAware, RequestAware {

	private GoodsBean goodsBean;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int gid;
	@Autowired
	private GoodsService goodsService;
	private ShowGoodsService showGoodsService;

	public String indexGoods(){
		List<GoodsInfo> goodsInfos = goodsService.listGoodsInIndex();
		Gson gson = new Gson();
		String jsonResult = gson.toJson(goodsInfos);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(jsonResult);//写出响应数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "none";
	}
	
	//显示商品详情
		public String showGoods(){
			List<GoodsBean> goodsbeans = showGoodsService.listShowGoods(gid);
			Gson gson = new Gson();
			String jsonResult = gson.toJson(goodsbeans);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println(jsonResult);//写出响应数据
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
	public GoodsBean getModel() {
		goodsBean = new GoodsBean();
		return goodsBean;
	}

	

	
}
