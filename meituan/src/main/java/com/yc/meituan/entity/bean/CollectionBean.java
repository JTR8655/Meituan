package com.yc.meituan.entity.bean;

public class CollectionBean {
	private Integer cid;
	private Integer muid;
	private Integer gid;
	private String b_retime;
	private String gstatus;
	private String img;
	private String gtitle1;
	private float gprice2;

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

	public float getGprice2() {
		return gprice2;
	}

	public void setGprice2(float gprice2) {
		this.gprice2 = gprice2;
	}

	public String getGstatus() {
		return gstatus;
	}

	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getMuid() {
		return muid;
	}

	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getB_retime() {
		return b_retime;
	}

	public void setB_retime(String b_retime) {
		this.b_retime = b_retime;
	}

	@Override
	public String toString() {
		return "CollectionBean [cid=" + cid + ", muid=" + muid + ", gid=" + gid + ", b_retime=" + b_retime
				+ ", gstatus=" + gstatus + ", img=" + img + ", gtitle1=" + gtitle1 + ", gprice2=" + gprice2 + "]";
	}

}
