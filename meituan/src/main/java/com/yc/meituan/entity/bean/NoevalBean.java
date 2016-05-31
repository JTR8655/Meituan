package com.yc.meituan.entity.bean;

import java.io.Serializable;

public class NoevalBean implements Serializable{
	private static final long serialVersionUID = 950131738480951018L;
	private Integer oid;
	private Integer gid;
	private Integer muid;
	private String gtitle1;
	private String img;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getMuid() {
		return muid;
	}

	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	public String getGtitle1() {
		return gtitle1;
	}

	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "NoevalBean [oid=" + oid + ", gid=" + gid + ", muid=" + muid + ", gtitle1=" + gtitle1 + ", img=" + img
				+ "]";
	}

}
