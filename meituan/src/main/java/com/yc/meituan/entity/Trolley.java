package com.yc.meituan.entity;

public class Trolley {
    private Integer tid;

    private Integer muid;

    private Integer gid;

    private Integer tcount;

    private String temp1;

    private String temp2;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
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

	@Override
	public String toString() {
		return "Trolley [tid=" + tid + ", muid=" + muid + ", gid=" + gid + ", tcount=" + tcount + ", temp1=" + temp1
				+ ", temp2=" + temp2 + "]";
	}
}