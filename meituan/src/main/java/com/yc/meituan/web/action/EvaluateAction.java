package com.yc.meituan.web.action;

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
import com.yc.meituan.entity.bean.EvaluatedBean;
import com.yc.meituan.service.EvaluateService;
import com.yc.meituan.service.UorderService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("evaluateAction")
public class EvaluateAction implements ModelDriven<Evaluate>, SessionAware, RequestAware {

	private Evaluate evaluate;
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
	
}
