package com.yc.meituan.web.bean;

public class SellerGoodsBean {
	private int gid;// 商品编号
	private int sid;// 商家编号
	private String gtitle1;// 主标题
	private String gtitle2;// 副标题
	private String privilege;// 优惠折扣
	private float gprice1;// 原价
	private float gprice2;// 现价
	private int gsoldcount;// 已购数
	private String img;// 照片
	private String b_retime;// 有效期
	private String b_usetime;// 使用时间
	private String b_ordertip;// 预约提示
	private String b_parlor;// 包间
	private String b_pack;// 食堂外带
	private String b_serve;// 商家服务
	private String b_limittip;// 限购限用提醒
	private float d_price1;// 套餐单价
	private int d_count;// 套餐数量/规格
	private String d_taocan;
	private String text;
	private int pjCount;
	private int collectCount;
	private String saccounts;
	private String spwd;
	private String saddress;
	private String sshopname;
	private String stype;
	private String sname;
	private String slicense;
	private String sphone;
	private Integer status;
	private String temp1;
	private String temp2;
	private String opwd;
	private String ostatus;
	private String uaccounts;
	private int totalTodaySold;
	public String usetime;

	public String getUsetime() {
		return usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}

	public int getTotalTodaySold() {
		return totalTodaySold;
	}

	public void setTotalTodaySold(int totalTodaySold) {
		this.totalTodaySold = totalTodaySold;
	}

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

	public String getOcount() {
		return ocount;
	}

	public void setOcount(String ocount) {
		this.ocount = ocount;
	}

	public String getOprice() {
		return oprice;
	}

	public void setOprice(String oprice) {
		this.oprice = oprice;
	}

	private Integer oid; // 订单id
	private String oidentifier;
	private String otime;
	private String opaytime;
	private String ocount;
	private String oprice;

	public String getUaccounts() {
		return uaccounts;
	}

	public void setUaccounts(String uaccounts) {
		this.uaccounts = uaccounts;
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

	public float getGprice1() {
		return gprice1;
	}

	public void setGprice1(float gprice1) {
		this.gprice1 = gprice1;
	}

	public float getGprice2() {
		return gprice2;
	}

	public void setGprice2(float gprice2) {
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

	public float getD_price1() {
		return d_price1;
	}

	public void setD_price1(float d_price1) {
		this.d_price1 = d_price1;
	}

	public int getD_count() {
		return d_count;
	}

	public void setD_count(int d_count) {
		this.d_count = d_count;
	}

	public String getD_taocan() {
		return d_taocan;
	}

	public void setD_taocan(String d_taocan) {
		this.d_taocan = d_taocan;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPjCount() {
		return pjCount;
	}

	public void setPjCount(int pjCount) {
		this.pjCount = pjCount;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public String getSaccounts() {
		return saccounts;
	}

	public void setSaccounts(String saccounts) {
		this.saccounts = saccounts;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSshopname() {
		return sshopname;
	}

	public void setSshopname(String sshopname) {
		this.sshopname = sshopname;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSlicense() {
		return slicense;
	}

	public void setSlicense(String slicense) {
		this.slicense = slicense;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	@Override
	public String toString() {
		return "SellerGoodsBean [gid=" + gid + ", sid=" + sid + ", gtitle1=" + gtitle1 + ", gtitle2=" + gtitle2
				+ ", privilege=" + privilege + ", gprice1=" + gprice1 + ", gprice2=" + gprice2 + ", gsoldcount="
				+ gsoldcount + ", img=" + img + ", b_retime=" + b_retime + ", b_usetime=" + b_usetime + ", b_ordertip="
				+ b_ordertip + ", b_parlor=" + b_parlor + ", b_pack=" + b_pack + ", b_serve=" + b_serve
				+ ", b_limittip=" + b_limittip + ", d_price1=" + d_price1 + ", d_count=" + d_count + ", d_taocan="
				+ d_taocan + ", text=" + text + ", pjCount=" + pjCount + ", collectCount=" + collectCount
				+ ", saccounts=" + saccounts + ", spwd=" + spwd + ", saddress=" + saddress + ", sshopname=" + sshopname
				+ ", stype=" + stype + ", sname=" + sname + ", slicense=" + slicense + ", sphone=" + sphone
				+ ", status=" + status + ", temp1=" + temp1 + ", temp2=" + temp2 + ", opwd=" + opwd + ", ostatus="
				+ ostatus + ", uaccounts=" + uaccounts + ", totalTodaySold=" + totalTodaySold + ", usetime=" + usetime
				+ ", oid=" + oid + ", oidentifier=" + oidentifier + ", otime=" + otime + ", opaytime=" + opaytime
				+ ", ocount=" + ocount + ", oprice=" + oprice + "]";
	}

}
