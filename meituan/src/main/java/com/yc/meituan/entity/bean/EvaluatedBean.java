package com.yc.meituan.entity.bean;

public class EvaluatedBean {
	private Integer gid;
	private String img;
	private String gtitle1;
	private String egrade_4;
	private String econtent;
	private String temp1;
	public String getUheadimg() {
		return uheadimg;
	}

	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}

	public String getUaccounts() {
		return uaccounts;
	}

	public void setUaccounts(String uaccounts) {
		this.uaccounts = uaccounts;
	}

	private String uheadimg;
	private String uaccounts;
	
	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGtitle1() {
		return gtitle1;
	}

	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}

	public String getEgrade_4() {
		return egrade_4;
	}

	public void setEgrade_4(String egrade_4) {
		this.egrade_4 = egrade_4;
	}

	public String getEcontent() {
		return econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	@Override
	public String toString() {
		return "EvaluatedBean [gid=" + gid + ", img=" + img + ", gtitle1=" + gtitle1 + ", egrade_4=" + egrade_4
				+ ", econtent=" + econtent + ", temp1=" + temp1 + ", uheadimg=" + uheadimg + ", uaccounts=" + uaccounts
				+ "]";
	}
}
