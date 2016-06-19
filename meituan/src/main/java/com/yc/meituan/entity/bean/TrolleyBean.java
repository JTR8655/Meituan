package com.yc.meituan.entity.bean;

public class TrolleyBean {
	private Integer tid;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	private Integer gid;
	private Integer tcount;
	private String gtitle1;
	private String gtitle2;
	private Double gprice1;
	private String img;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getTcount() {
		return tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	public String getGtitle1() {
		return gtitle1;
	}

	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}

	public String getGtitle2() {
		return gtitle2;
	}

	public void setGtitle2(String gtitle2) {
		this.gtitle2 = gtitle2;
	}

	public Double getGprice1() {
		return gprice1;
	}

	public void setGprice1(Double gprice1) {
		this.gprice1 = gprice1;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "TrolleyBean [tid=" + tid + ", gid=" + gid + ", tcount=" + tcount + ", gtitle1=" + gtitle1 + ", gtitle2="
				+ gtitle2 + ", gprice1=" + gprice1 + ", img=" + img + "]";
	}

}
