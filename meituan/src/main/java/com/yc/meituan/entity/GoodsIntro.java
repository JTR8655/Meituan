package com.yc.meituan.entity;

public class GoodsIntro {
    private Integer gid;

    private Integer sid;

    private String bRetime;

    private String bUsetime;

    private String bOrdertip;

    private String bParlor;

    private String bPack;

    private String bServe;

    private String bLimittip;

    private String bPrompt;

    private String dTaocan;

    private Double dPrice1;

    private Integer dCount;

    private String temp1;

    private String temp2;

    private String temp3;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getbRetime() {
        return bRetime;
    }

    public void setbRetime(String bRetime) {
        this.bRetime = bRetime == null ? null : bRetime.trim();
    }

    public String getbUsetime() {
        return bUsetime;
    }

    public void setbUsetime(String bUsetime) {
        this.bUsetime = bUsetime == null ? null : bUsetime.trim();
    }

    public String getbOrdertip() {
        return bOrdertip;
    }

    public void setbOrdertip(String bOrdertip) {
        this.bOrdertip = bOrdertip == null ? null : bOrdertip.trim();
    }

    public String getbParlor() {
        return bParlor;
    }

    public void setbParlor(String bParlor) {
        this.bParlor = bParlor == null ? null : bParlor.trim();
    }

    public String getbPack() {
        return bPack;
    }

    public void setbPack(String bPack) {
        this.bPack = bPack == null ? null : bPack.trim();
    }

    public String getbServe() {
        return bServe;
    }

    public void setbServe(String bServe) {
        this.bServe = bServe == null ? null : bServe.trim();
    }

    public String getbLimittip() {
        return bLimittip;
    }

    public void setbLimittip(String bLimittip) {
        this.bLimittip = bLimittip == null ? null : bLimittip.trim();
    }

    public String getbPrompt() {
        return bPrompt;
    }

    public void setbPrompt(String bPrompt) {
        this.bPrompt = bPrompt == null ? null : bPrompt.trim();
    }

    public String getdTaocan() {
        return dTaocan;
    }

    public void setdTaocan(String dTaocan) {
        this.dTaocan = dTaocan == null ? null : dTaocan.trim();
    }

    public Double getdPrice1() {
        return dPrice1;
    }

    public void setdPrice1(Double dPrice1) {
        this.dPrice1 = dPrice1;
    }

    public Integer getdCount() {
        return dCount;
    }

    public void setdCount(Integer dCount) {
        this.dCount = dCount;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

	@Override
	public String toString() {
		return "GoodsIntro [gid=" + gid + ", sid=" + sid + ", bRetime=" + bRetime + ", bUsetime=" + bUsetime
				+ ", bOrdertip=" + bOrdertip + ", bParlor=" + bParlor + ", bPack=" + bPack + ", bServe=" + bServe
				+ ", bLimittip=" + bLimittip + ", bPrompt=" + bPrompt + ", dTaocan=" + dTaocan + ", dPrice1=" + dPrice1
				+ ", dCount=" + dCount + ", temp1=" + temp1 + ", temp2=" + temp2 + ", temp3=" + temp3 + "]";
	}
}