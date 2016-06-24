package com.yc.meituan.entity;

public class GoodsInfo {
    private Integer gid;

    private String gdate;

    private String privilege;

    private Integer sid;

    private String gtitle1;

    private String gtitle2;

    private Double gprice1;

    private Double gprice2;

    private Integer gsoldcount;

    private String img;

    private String text;

    private String temp1;

    private String temp2;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGtitle1() {
        return gtitle1;
    }

    public void setGtitle1(String gtitle1) {
        this.gtitle1 = gtitle1 == null ? null : gtitle1.trim();
    }

    public String getGtitle2() {
        return gtitle2;
    }

    public void setGtitle2(String gtitle2) {
        this.gtitle2 = gtitle2 == null ? null : gtitle2.trim();
    }

    public Double getGprice1() {
        return gprice1;
    }

    public void setGprice1(Double gprice1) {
        this.gprice1 = gprice1;
    }

    public Double getGprice2() {
        return gprice2;
    }

    public void setGprice2(Double gprice2) {
        this.gprice2 = gprice2;
    }

    public Integer getGsoldcount() {
        return gsoldcount;
    }

    public void setGsoldcount(Integer gsoldcount) {
        this.gsoldcount = gsoldcount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
		return "GoodsInfo [gid=" + gid + ", gdate=" + gdate + ", privilege=" + privilege + ", sid=" + sid + ", gtitle1="
				+ gtitle1 + ", gtitle2=" + gtitle2 + ", gprice1=" + gprice1 + ", gprice2=" + gprice2 + ", gsoldcount="
				+ gsoldcount + ", img=" + img + ", text=" + text + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

    
}