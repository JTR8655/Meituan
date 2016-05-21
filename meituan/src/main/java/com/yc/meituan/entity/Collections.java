package com.yc.meituan.entity;

public class Collections {
    private Integer cid;

    private Integer muid;

    private Integer gid;

    private String cstatus;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus == null ? null : cstatus.trim();
    }

	@Override
	public String toString() {
		return "Collection [cid=" + cid + ", muid=" + muid + ", gid=" + gid + ", cstatus=" + cstatus + "]";
	}
}