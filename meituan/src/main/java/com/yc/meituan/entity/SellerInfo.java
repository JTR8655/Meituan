package com.yc.meituan.entity;

public class SellerInfo {
    private Integer sid;

    private String saccounts;

    private String spwd;

    private String saddress;

    private String sshopname;

    private String stype;

    private String sname;

    private String semail;

    private String slicense;

    private String sphone;

    private Integer status;

    private String temp1;

    private String temp2;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSaccounts() {
        return saccounts;
    }

    public void setSaccounts(String saccounts) {
        this.saccounts = saccounts == null ? null : saccounts.trim();
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd == null ? null : spwd.trim();
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }

    public String getSshopname() {
        return sshopname;
    }

    public void setSshopname(String sshopname) {
        this.sshopname = sshopname == null ? null : sshopname.trim();
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype == null ? null : stype.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail == null ? null : semail.trim();
    }

    public String getSlicense() {
        return slicense;
    }

    public void setSlicense(String slicense) {
        this.slicense = slicense == null ? null : slicense.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
		return "SellerInfo [sid=" + sid + ", saccounts=" + saccounts + ", spwd=" + spwd + ", saddress=" + saddress
				+ ", sshopname=" + sshopname + ", stype=" + stype + ", sname=" + sname + ", semail=" + semail
				+ ", slicense=" + slicense + ", sphone=" + sphone + ", status=" + status + ", temp1=" + temp1
				+ ", temp2=" + temp2 + "]";
	}
}