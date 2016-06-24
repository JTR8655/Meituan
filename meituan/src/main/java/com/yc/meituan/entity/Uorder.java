package com.yc.meituan.entity;

public class Uorder {
	private Integer oid;

	private String oidentifier;

	private Integer muid;

	private Integer gid;

	private String otime;

	private String ostatus;

	private String opwd;

	private String opaytime;

	private Integer ocount;

	private Integer pjstatus;

	private String temp2;

	private String usetime;//消费时间

	public String getUsetime() {
		return usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
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
		this.ostatus = ostatus == null ? null : ostatus.trim();
	}

	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd == null ? null : opwd.trim();
	}

	public String getOpaytime() {
		return opaytime;
	}

	public void setOpaytime(String opaytime) {
		this.opaytime = opaytime;
	}

	public Integer getOcount() {
		return ocount;
	}

	public void setOcount(Integer ocount) {
		this.ocount = ocount;
	}

	public Integer getPjstatus() {
		return pjstatus;
	}

	public void setPjstatus(Integer pjstatus) {
		this.pjstatus = pjstatus;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2 == null ? null : temp2.trim();
	}

	@Override
	public String toString() {
		return "Uorder [oid=" + oid + ", oidentifier=" + oidentifier + ", muid=" + muid + ", gid=" + gid + ", otime="
				+ otime + ", ostatus=" + ostatus + ", opwd=" + opwd + ", opaytime=" + opaytime + ", ocount=" + ocount
				+ ", pjstatus=" + pjstatus + ", temp2=" + temp2 + ", usetime=" + usetime + "]";
	}

}