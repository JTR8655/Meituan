package meituan.po;

public class GoodsOrderPo {
	private int gid;		//商品编号
	private String gtitle1; //商品名
	private int oid;		//订单表号
	private int oidentifier; //订单号
	private int muid;		//用户账号
	private String otime;	//下单时间
	private String ostatus;	//订单状态
	private String opwd;	//美团券密码
	private String opaytime;	//付款时间
	private int ocount;		//数量
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGtitle1() {
		return gtitle1;
	}
	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOidentifier() {
		return oidentifier;
	}
	public void setOidentifier(int oidentifier) {
		this.oidentifier = oidentifier;
	}
	public int getMuid() {
		return muid;
	}
	public void setMuid(int muid) {
		this.muid = muid;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public String getOpwd() {
		return opwd;
	}
	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}
	public String getOpaytime() {
		return opaytime;
	}
	public void setOpaytime(String opaytime) {
		this.opaytime = opaytime;
	}
	public int getOcount() {
		return ocount;
	}
	public void setOcount(int ocount) {
		this.ocount = ocount;
	}
	@Override
	public String toString() {
		return "GoodsOrderPo [gid=" + gid + ", gtitle1=" + gtitle1 + ", oid="
				+ oid + ", oidentifier=" + oidentifier + ", muid=" + muid
				+ ", otime=" + otime + ", ostatus=" + ostatus + ", opwd="
				+ opwd + ", opaytime=" + opaytime + ", ocount=" + ocount + "]";
	}
	public GoodsOrderPo(int gid, String gtitle1, int oid, int oidentifier,
			int muid, String otime, String ostatus, String opwd,
			String opaytime, int ocount) {
		super();
		this.gid = gid;
		this.gtitle1 = gtitle1;
		this.oid = oid;
		this.oidentifier = oidentifier;
		this.muid = muid;
		this.otime = otime;
		this.ostatus = ostatus;
		this.opwd = opwd;
		this.opaytime = opaytime;
		this.ocount = ocount;
	}
	public GoodsOrderPo() {
		super();
	}
}
