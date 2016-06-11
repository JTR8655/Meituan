package com.yc.meituan.entity.bean;


public class UorderBean {
	private Integer oid; // 订单id
	private String opwd;
	private String oidentifier; // 订单编号
	private Integer muid; // 用户id
	private Integer gid; // 商品id
	private String ostatus; // 订单状态
	private Integer ocount; // 数量
	private String gtitle1; // 标题1
	private float gprice2;// 现价
	private String img; // 图片路径
	private Integer sid; // 商家id
	private String b_retime; // 有效时间
	private Double oprice;
	private String otime;
	private String opaytime;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOidentifier() {
		return oidentifier;
	}

	public void setOidentifier(String oidentifier) {
		this.oidentifier = oidentifier;
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

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public Integer getOcount() {
		return ocount;
	}

	public void setOcount(Integer ocount) {
		this.ocount = ocount;
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

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getB_retime() {
		return b_retime;
	}

	public void setB_retime(String b_retime) {
		this.b_retime = b_retime;
	}

	public float getGprice2() {
		return gprice2;
	}

	public void setGprice2(float gprice2) {
		this.gprice2 = gprice2;
	}

	public Double getOprice() {
		return oprice;
	}

	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}

	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}

	public String getOtime() {
		return otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public String getOpaytime() {
		return opaytime;
	}

	public void setOpaytime(String opaytime) {
		this.opaytime = opaytime;
	}

	@Override
	public String toString() {
		return "UorderBean [oid=" + oid + ", opwd=" + opwd + ", oidentifier=" + oidentifier + ", muid=" + muid
				+ ", gid=" + gid + ", ostatus=" + ostatus + ", ocount=" + ocount + ", gtitle1=" + gtitle1 + ", gprice2="
				+ gprice2 + ", img=" + img + ", sid=" + sid + ", b_retime=" + b_retime + ", oprice=" + oprice
				+ ", otime=" + otime + ", opaytime=" + opaytime + "]";
	}

}
