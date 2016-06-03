package com.yc.meituan.entity;

public class Evaluate {

    private Integer eid;//评价表编号

    private Integer muid;//会员编号

    private Integer oid;//订单编号

    private Double egrade_1;//服务分

    private Double egrade_2;//口味分

    private Double egrade_3;//环境分

    private Double egrade_4;//总评分
    
    private Integer hid;

    private String econtent;//长时间未评价，系统默认好评

    private String img;//评价图片

    private Integer hidename;//评论人的用户名，默认为匿名

    private String temp1;//评论时间

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getMuid() {
		return muid;
	}

	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getEgrade_1() {
		return egrade_1;
	}

	public void setEgrade_1(Double egrade_1) {
		this.egrade_1 = egrade_1;
	}

	public Double getEgrade_2() {
		return egrade_2;
	}

	public void setEgrade_2(Double egrade_2) {
		this.egrade_2 = egrade_2;
	}

	public Double getEgrade_3() {
		return egrade_3;
	}

	public void setEgrade_3(Double egrade_3) {
		this.egrade_3 = egrade_3;
	}

	public Double getEgrade_4() {
		return egrade_4;
	}

	public void setEgrade_4(Double egrade_4) {
		this.egrade_4 = egrade_4;
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getEcontent() {
		return econtent;
	}

	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getHidename() {
		return hidename;
	}

	public void setHidename(Integer hidename) {
		this.hidename = hidename;
	}

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	@Override
	public String toString() {
		return "Evaluate [eid=" + eid + ", muid=" + muid + ", oid=" + oid
				+ ", egrade_1=" + egrade_1 + ", egrade_2=" + egrade_2
				+ ", egrade_3=" + egrade_3 + ", egrade_4=" + egrade_4
				+ ", hid=" + hid + ", econtent=" + econtent + ", img=" + img
				+ ", hidename=" + hidename + ", temp1=" + temp1 + "]";
	}

	public Evaluate(Integer eid, Integer muid, Integer oid, Double egrade_1,
			Double egrade_2, Double egrade_3, Double egrade_4, Integer hid,
			String econtent, String img, Integer hidename, String temp1) {
		this.eid = eid;
		this.muid = muid;
		this.oid = oid;
		this.egrade_1 = egrade_1;
		this.egrade_2 = egrade_2;
		this.egrade_3 = egrade_3;
		this.egrade_4 = egrade_4;
		this.hid = hid;
		this.econtent = econtent;
		this.img = img;
		this.hidename = hidename;
		this.temp1 = temp1;
	}

	public Evaluate() {
	}

}