package meituan.po;

public class UorderPo {
	private Integer oid;				//订单表编号
	private Integer oidentifier;		//订单号
	private Integer muid;				//用户帐号
	private Integer gid;				//商品编号
	private String otime;			//下单时间
	private String ostatus;			//订单状态
	private String opwd;			//美团券密码
	private String opaytime;		//付款时间
	private Integer ocount;			//数量
	private Integer pjStatus;		//评价状态
	
	public Integer getOcount() {
		return ocount;
	}
	public void setOcount(Integer ocount) {
		this.ocount = ocount;
	}
	public Integer getPjStatus() {
		return pjStatus;
	}
	public void setPjStatus(Integer pjStatus) {
		this.pjStatus = pjStatus;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getOidentifier() {
		return oidentifier;
	}
	public void setOidentifier(Integer oidentifier) {
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
	
	public UorderPo(Integer oid, Integer oidentifier, Integer muid, Integer gid, String otime,
			String ostatus, String opwd, String opaytime, Integer ocount,
			Integer pjStatus) {
		super();
		this.oid = oid;
		this.oidentifier = oidentifier;
		this.muid = muid;
		this.gid = gid;
		this.otime = otime;
		this.ostatus = ostatus;
		this.opwd = opwd;
		this.opaytime = opaytime;
		this.ocount = ocount;
		this.pjStatus = pjStatus;
	}
	@Override
	public String toString() {
		return "UorderPo [oid=" + oid + ", oidentifier=" + oidentifier
				+ ", muid=" + muid + ", gid=" + gid + ", otime=" + otime
				+ ", ostatus=" + ostatus + ", opwd=" + opwd + ", opaytime="
				+ opaytime + ", ocount=" + ocount + ", pjStatus=" + pjStatus
				+ "]";
	}
	public UorderPo() {
		super();
	}
	
}
