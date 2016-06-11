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
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.Evaluate;
import com.yc.meituan.entity.UserInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.EvaluatedBean;
import com.yc.meituan.service.EvaluateService;
import com.yc.meituan.service.UorderService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("evaluateAction")
public class EvaluateAction implements ModelDriven<Evaluate>, SessionAware, RequestAware {

	private Evaluate evaluate;
	EvaluateBean eva=new EvaluateBean();
	
	private Map<String, Object> session;
	private Map<String, Object> request;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private UorderService uorderService;
	
	public String addEvaluate(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			return "none";
		}
		LogManager.getLogger().debug("取到的数据：" + evaluate);
		evaluate.setHidename(evaluate.getHid());
		evaluate.setMuid(user.getMuid());
		if(null == evaluate.getImg()){
			evaluate.setImg("");
		}
		
		try{
			evaluateService.addEvaluate(evaluate);
			uorderService.updatePlStatus(evaluate.getOid());
			AjaxUtil.stringAjaxResponse("1");
		}catch(Exception e){
			AjaxUtil.stringAjaxResponse("0");
			e.printStackTrace();
		}
		return "none";
	}
	
	
	public String listPj(){
		UserInfo user = (UserInfo) session.get(MeituanData.LOGIN_USER);
		if(null == user){
			return "none";
		}
		List<EvaluatedBean> evaluated = evaluateService.listPj(user.getMuid());
		if(null != evaluated && evaluated.size() > 0){
			AjaxUtil.objectAjaxResponse(evaluated);
		}
		return "none";
	}

	//显示评价总分
		public String showEvaluatePoint() {
			LogManager.getLogger().debug("=========>"+eva);
			List<EvaluateBean> evaluates = evaluateService.listshowEvaluatePoint(eva.getGid());
			Gson gson = new Gson();
			String jsonResult = gson.toJson(evaluates);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println(jsonResult);// 写出响应数据
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "none";
		}
		//显示评价内容
			public String showGoodsDetails() {
				List<EvaluateBean> evaluates = evaluateService.listshowGoodsDetails(eva.getGid());
				Gson gson = new Gson();
				String jsonResult = gson.toJson(evaluates);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("utf-8");
				response.setContentType("charset=utf-8");
				try {
					PrintWriter out = response.getWriter();
					out.println(jsonResult);// 写出响应数据
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
	public Evaluate getModel() {
		evaluate = new Evaluate();
		return evaluate;
	}


	public EvaluateBean getEvaluateBean() {
		return eva;
	}


	public void setEvaluateBean(EvaluateBean evaluateBean) {
		this.eva = evaluateBean;
	}
	
}
