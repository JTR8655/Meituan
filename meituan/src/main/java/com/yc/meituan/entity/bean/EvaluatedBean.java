package com.yc.meituan.entity.bean;

public class EvaluatedBean {
	private Integer gid;
	private String img;
	private String gtitle1;
	private String egrade_4;
	private String econtent;

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
				+ ", econtent=" + econtent + "]";
	}

}
