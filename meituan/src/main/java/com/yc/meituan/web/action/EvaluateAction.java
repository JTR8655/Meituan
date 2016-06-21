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
	private EvaluateBean evaluateBean = new EvaluateBean();
	
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
		
		if(evaluate.getEcontent().toLowerCase().indexOf("script") >= 0){
			AjaxUtil.stringAjaxResponse("3");
			return "none";
		}
		
		evaluate.setHidename(evaluate.getHid());
		evaluate.setMuid(user.getMuid());
		if(null == evaluate.getImg()){
			evaluate.setImg("");
		}
		
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sf.format(d);
		evaluate.setTemp1(time);
		
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
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		List<EvaluatedBean> evaluated = evaluateService.listPj(user.getMuid());
		LogManager.getLogger().debug(evaluated.size());
		if(null != evaluated && evaluated.size() > 0){
			AjaxUtil.objectAjaxResponse(evaluated);
		}else{
			AjaxUtil.stringAjaxResponse("0");
		}
		return "none";
	}

	//显示评价总分
	public String showEvaluatePoint(){
		LogManager.getLogger().debug("=========>"+evaluate);
		List<EvaluateBean> evaluates = evaluateService.listshowEvaluatePoint(evaluate.getGid());	
		LogManager.getLogger().debug(evaluates);
		AjaxUtil.objectAjaxResponse(evaluates);
		return "none";
	}
	//显示评价内容
		public String showGoodsDetails(){
			LogManager.getLogger().debug("=========>"+evaluate);
			List<EvaluateBean> evaluates = evaluateService.listshowGoodsDetails(evaluate.getGid());	
			LogManager.getLogger().debug(evaluates);
			AjaxUtil.objectAjaxResponse(evaluates);
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
		return evaluateBean;
	}


	public void setEvaluateBean(EvaluateBean evaluateBean) {
		this.evaluateBean = evaluateBean;
	}
	
}
