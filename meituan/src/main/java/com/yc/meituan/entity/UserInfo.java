package com.yc.meituan.entity;

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

    private String ubirth;

    private String umarital;

    private String ujob;

    private String uheadimg;

    private String uinterest;

    private Integer ustatus;

    private String uaddr;

    private String uregtime;

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
        this.uaccounts = uaccounts == null ? null : uaccounts.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex == null ? null : usex.trim();
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

    public String getUbirth() {
        return ubirth;
    }

    public void setUbirth(String ubirth) {
        this.ubirth = ubirth;
    }

    public String getUmarital() {
        return umarital;
    }

    public void setUmarital(String umarital) {
        this.umarital = umarital == null ? null : umarital.trim();
    }

    public String getUjob() {
        return ujob;
    }

    public void setUjob(String ujob) {
        this.ujob = ujob == null ? null : ujob.trim();
    }

    public String getUheadimg() {
        return uheadimg;
    }

    public void setUheadimg(String uheadimg) {
        this.uheadimg = uheadimg == null ? null : uheadimg.trim();
    }

    public String getUinterest() {
        return uinterest;
    }

    public void setUinterest(String uinterest) {
        this.uinterest = uinterest == null ? null : uinterest.trim();
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
        this.uaddr = uaddr == null ? null : uaddr.trim();
    }

    public String getUregtime() {
        return uregtime;
    }

    public void setUregtime(String uregtime) {
        this.uregtime = uregtime == null ? null : uregtime.trim();
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