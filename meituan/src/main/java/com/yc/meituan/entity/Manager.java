package com.yc.meituan.entity;

public class Manager {
    private Integer mid;

    private String mname;

    private String mpwd;

    private String temp1;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd == null ? null : mpwd.trim();
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", mpwd=" + mpwd + ", temp1=" + temp1 + "]";
	}
}