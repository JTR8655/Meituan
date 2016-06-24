package com.yc.meituan.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.yc.meituan.entity.SellerInfo;
import com.yc.meituan.entity.bean.EvaluateBean;
import com.yc.meituan.entity.bean.GoodsBean;
import com.yc.meituan.service.GoodsIntroService;
import com.yc.meituan.service.SellerService;
import com.yc.meituan.util.AjaxUtil;
import com.yc.meituan.util.MeituanData;

@Controller("imageAction")
public class ImageAction implements ModelDriven<GoodsBean>, SessionAware, RequestAware {
	
	private Map<String, Object> session;
	private Map<String, Object> request;
	private GoodsBean goodsBean;
	
	@Autowired
	SellerService sellerService;
	@Autowired
	GoodsIntroService goodsIntroService;
	
	private File[] image;//上传的文件对象XXX
	private String[] imageFileName;//上传的文件名XXXFileName
	private String[] imageContentType;//上传的文件类型XXXContentType
	
	public File[] getImage() {
		return image;
	}

	public void setImage(File[] image) {
		this.image = image;
	}

	public String[] getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String[] getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String upload() {	
		SellerInfo seller = (SellerInfo) session.get(MeituanData.LOGIN_SELLER);
		if(null == seller){
			AjaxUtil.stringAjaxResponse("2");
			return "none";
		}
		
		String savePath=ServletActionContext.getServletContext().getRealPath("/upload");
		LogManager.getLogger().debug("上传服务器的位置是："+savePath);
		try {
			for(int i=0;i<image.length;i++){
				FileUtils.copyFile(image[i],new File(savePath+File.separator+imageFileName[i]));
			}
			goodsBean.setImg("upload/"+imageFileName[0]);
			goodsBean.setD_count(1);
			goodsBean.setD_price1(goodsBean.getGprice2());
			goodsBean.setD_taocan(goodsBean.getGtitle1());
			goodsBean.setSshopname(seller.getSshopname());
			if(sAddGoods()){
				AjaxUtil.stringAjaxResponse("1");
			}else{
				AjaxUtil.stringAjaxResponse("0");
			}
		} catch (IOException e) {
			AjaxUtil.stringAjaxResponse("0");
			e.printStackTrace();
		}
		return "success";
	}
	
	//商家添加商品
	public boolean sAddGoods(){
		try {
			goodsBean = sellerService.sAddGoods(goodsBean);
			goodsIntroService.sAddgoodsIntro(goodsBean);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
