package com.yc.meituan.entity;

public class Evaluate {

    private Integer eid;//评价表编号

    private Integer muid;//会员编号

    private Integer oid;//订单编号

    private Double egrade1;//服务分

    private Double egrade2;//口味分

    private Double egrade3;//环境分

    private Double egrade4;//总评分

    private String econtent;//长时间未评价，系统默认好评

    private String img;//评价图片

    private Integer hidename;//评论人的用户名，默认为匿名

    private String temp1;//备用字段

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getMuid() {
        return muid;
    }

    public void setMuid(Integer muid) {
        this.muid = muid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getEgrade1() {
        return egrade1;
    }

    public void setEgrade1(Double egrade1) {
        this.egrade1 = egrade1;
    }

    public Double getEgrade2() {
        return egrade2;
    }

    public void setEgrade2(Double egrade2) {
        this.egrade2 = egrade2;
    }

    public Double getEgrade3() {
        return egrade3;
    }

    public void setEgrade3(Double egrade3) {
        this.egrade3 = egrade3;
    }

    public Double getEgrade4() {
        return egrade4;
    }

    public void setEgrade4(Double egrade4) {
        this.egrade4 = egrade4;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent == null ? null : econtent.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getHidename() {
        return hidename;
    }

    public void setHidename(Integer hidename) {
        this.hidename = hidename;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

	@Override
	public String toString() {
		return "Evaluate [eid=" + eid + ", muid=" + muid + ", oid=" + oid + ", egrade1=" + egrade1 + ", egrade2="
				+ egrade2 + ", egrade3=" + egrade3 + ", egrade4=" + egrade4 + ", econtent=" + econtent + ", img=" + img
				+ ", hidename=" + hidename + ", temp1=" + temp1 + "]";
	}
}