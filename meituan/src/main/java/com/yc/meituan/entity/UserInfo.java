package com.yc.meituan.entity;

import java.util.Date;

//实体类
public class UserInfo {
	private Integer muid;

	private String uaccounts;

	private String upwd;

	private String uemail;

	private String uphone;

	private String usex;

	private Double ubalance;

	private Integer upoint;

	private Date ubirth;

	private String umarital;

	private String ujob;

	private String uheadimg;

	private String uinterest;

	private Integer ustatus;

	private String uaddr;

	private Date uregtime;

	public UserInfo() {
		super();
	}

	public UserInfo(Integer muid, String uaccounts, String upwd, String uemail, String uphone, String usex,
			Double ubalance, Integer upoint, Date ubirth, String umarital, String ujob, String uheadimg,
			String uinterest, Integer ustatus, String uaddr, Date uregtime) {
		super();
		this.muid = muid;
		this.uaccounts = uaccounts;
		this.upwd = upwd;
		this.uemail = uemail;
		this.uphone = uphone;
		this.usex = usex;
		this.ubalance = ubalance;
		this.upoint = upoint;
		this.ubirth = ubirth;
		this.umarital = umarital;
		this.ujob = ujob;
		this.uheadimg = uheadimg;
		this.uinterest = uinterest;
		this.ustatus = ustatus;
		this.uaddr = uaddr;
		this.uregtime = uregtime;
	}

	public Integer getMuid() {
		return muid;
	}

	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	public String getUaccounts() {
		return uaccounts;
	}

	public void setUaccounts(String uaccounts) {
		this.uaccounts = uaccounts;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public Double getUbalance() {
		return ubalance;
	}

	public void setUbalance(Double ubalance) {
		this.ubalance = ubalance;
	}

	public Integer getUpoint() {
		return upoint;
	}

	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}

	public Date getUbirth() {
		return ubirth;
	}

	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}

	public String getUmarital() {
		return umarital;
	}

	public void setUmarital(String umarital) {
		this.umarital = umarital;
	}

	public String getUjob() {
		return ujob;
	}

	public void setUjob(String ujob) {
		this.ujob = ujob;
	}

	public String getUheadimg() {
		return uheadimg;
	}

	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}

	public String getUinterest() {
		return uinterest;
	}

	public void setUinterest(String uinterest) {
		this.uinterest = uinterest;
	}

	public Integer getUstatus() {
		return ustatus;
	}

	public void setUstatus(Integer ustatus) {
		this.ustatus = ustatus;
	}

	public String getUaddr() {
		return uaddr;
	}

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	public Date getUregtime() {
		return uregtime;
	}

	public void setUregtime(Date uregtime) {
		this.uregtime = uregtime;
	}

	@Override
	public String toString() {
		return "UserInfo [muid=" + muid + ", uaccounts=" + uaccounts + ", upwd=" + upwd + ", uemail=" + uemail
				+ ", uphone=" + uphone + ", usex=" + usex + ", ubalance=" + ubalance + ", upoint=" + upoint
				+ ", ubirth=" + ubirth + ", umarital=" + umarital + ", ujob=" + ujob + ", uheadimg=" + uheadimg
				+ ", uinterest=" + uinterest + ", ustatus=" + ustatus + ", uaddr=" + uaddr + ", uregtime=" + uregtime
				+ "]";
	}

}
