package com.yc.meituan.entity.bean;

public class EvaluateBean {
	private int gid;//商品编号
	private Integer oid;//订单编号
	private Double egrade_4;//总评分
	private double grade;//所有分支评价分总和
	private int amount;//评价总人数
	private String uaccounts;//评论人会员名
	private Integer hidename;//评论人的用户名，默认为匿名
	private String uheadimg;//评论人头像
	private String temp1;//评论时间
	private String econtent;//长时间未评价，系统默认好评
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getEgrade_4() {
		return egrade_4;
	}
	public void setEgrade_4(Double egrade_4) {
		this.egrade_4 = egrade_4;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getUaccounts() {
		return uaccounts;
	}
	public void setUaccounts(String uaccounts) {
		this.uaccounts = uaccounts;
	}
	public Integer getHidename() {
		return hidename;
	}
	public void setHidename(Integer hidename) {
		this.hidename = hidename;
	}
	public String getUheadimg() {
		return uheadimg;
	}
	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EvaluateBean [gid=" + gid + ", oid=" + oid + ", egrade_4="
				+ egrade_4 + ", grade=" + grade + ", amount=" + amount
				+ ", uaccounts=" + uaccounts + ", hidename=" + hidename
				+ ", uheadimg=" + uheadimg + ", temp1=" + temp1 + ", econtent="
				+ econtent + "]";
	}
	
	
}
