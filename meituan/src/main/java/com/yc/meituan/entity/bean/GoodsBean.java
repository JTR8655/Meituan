package com.yc.meituan.entity.bean;

public class GoodsBean {
	private int gid;// 商品编号
	private int sid;// 商家编号
	private String gtitle1;// 主标题
	private String gtitle2;// 副标题
	private String privilege;// 优惠折扣
	private double gprice1;// 原价
	private double gprice2;// 现价
	private int gsoldcount;// 已购数
	private String img;// 照片
	private String text;
	private String b_retime;// 有效期
	private String b_usetime;// 使用时间
	private String b_ordertip;// 预约提示
	private String b_parlor;// 包间
	private String b_pack;// 食堂外带
	private String b_serve;// 商家服务
	private String b_limittip;// 限购限用提醒
	private double d_price1;// 套餐单价
	private int d_count;// 套餐数量/规格
	private String d_taocan;
	private int pjCount;
	private String sshopname;
	private int collectCount;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public int getPjCount() {
		return pjCount;
	}

	public void setPjCount(int pjCount) {
		this.pjCount = pjCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public String getSshopname() {
		return sshopname;
	}

	public void setSshopname(String sshopname) {
		this.sshopname = sshopname;
	}

	public String getD_taocan() {
		return d_taocan;
	}

	public void setD_taocan(String d_taocan) {
		this.d_taocan = d_taocan;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public double getGprice1() {
		return gprice1;
	}

	public void setGprice1(double gprice1) {
		this.gprice1 = gprice1;
	}

	public double getGprice2() {
		return gprice2;
	}

	public void setGprice2(double gprice2) {
		this.gprice2 = gprice2;
	}

	public int getGsoldcount() {
		return gsoldcount;
	}

	public void setGsoldcount(int gsoldcount) {
		this.gsoldcount = gsoldcount;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getB_retime() {
		return b_retime;
	}

	public void setB_retime(String b_retime) {
		this.b_retime = b_retime;
	}

	public String getB_usetime() {
		return b_usetime;
	}

	public void setB_usetime(String b_usetime) {
		this.b_usetime = b_usetime;
	}

	public String getB_ordertip() {
		return b_ordertip;
	}

	public void setB_ordertip(String b_ordertip) {
		this.b_ordertip = b_ordertip;
	}

	public String getB_parlor() {
		return b_parlor;
	}

	public void setB_parlor(String b_parlor) {
		this.b_parlor = b_parlor;
	}

	public String getB_pack() {
		return b_pack;
	}

	public void setB_pack(String b_pack) {
		this.b_pack = b_pack;
	}

	public String getB_serve() {
		return b_serve;
	}

	public void setB_serve(String b_serve) {
		this.b_serve = b_serve;
	}

	public String getB_limittip() {
		return b_limittip;
	}

	public void setB_limittip(String b_limittip) {
		this.b_limittip = b_limittip;
	}

	public double getD_price1() {
		return d_price1;
	}

	public void setD_price1(double d_price1) {
		this.d_price1 = d_price1;
	}

	public int getD_count() {
		return d_count;
	}

	public void setD_count(int d_count) {
		this.d_count = d_count;
	}

	@Override
	public String toString() {
		return "GoodsBean [gid=" + gid + ", sid=" + sid + ", gtitle1=" + gtitle1 + ", gtitle2=" + gtitle2
				+ ", privilege=" + privilege + ", gprice1=" + gprice1 + ", gprice2=" + gprice2 + ", gsoldcount="
				+ gsoldcount + ", img=" + img + ", text=" + text + ", b_retime=" + b_retime + ", b_usetime=" + b_usetime
				+ ", b_ordertip=" + b_ordertip + ", b_parlor=" + b_parlor + ", b_pack=" + b_pack + ", b_serve="
				+ b_serve + ", b_limittip=" + b_limittip + ", d_price1=" + d_price1 + ", d_count=" + d_count
				+ ", d_taocan=" + d_taocan + ", pjCount=" + pjCount + ", sshopname=" + sshopname + ", collectCount="
				+ collectCount + "]";
	}

	public GoodsBean(int gid, int sid, String gtitle1, String gtitle2, String privilege, double gprice1, double gprice2,
			int gsoldcount, String img, String text, String b_retime, String b_usetime, String b_ordertip,
			String b_parlor, String b_pack, String b_serve, String b_limittip, double d_price1, int d_count,
			String d_taocan, int pjCount, String sshopname, int collectCount) {
		this.gid = gid;
		this.sid = sid;
		this.gtitle1 = gtitle1;
		this.gtitle2 = gtitle2;
		this.privilege = privilege;
		this.gprice1 = gprice1;
		this.gprice2 = gprice2;
		this.gsoldcount = gsoldcount;
		this.img = img;
		this.text = text;
		this.b_retime = b_retime;
		this.b_usetime = b_usetime;
		this.b_ordertip = b_ordertip;
		this.b_parlor = b_parlor;
		this.b_pack = b_pack;
		this.b_serve = b_serve;
		this.b_limittip = b_limittip;
		this.d_price1 = d_price1;
		this.d_count = d_count;
		this.d_taocan = d_taocan;
		this.pjCount = pjCount;
		this.sshopname = sshopname;
		this.collectCount = collectCount;
	}

	public GoodsBean() {
	}

}
