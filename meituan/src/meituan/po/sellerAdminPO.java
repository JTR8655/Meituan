package meituan.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class sellerAdminPO implements Serializable{

	private Integer sid;
	private Integer saccounts;
	private String sshopname;
	private String spwd;
	private String saddress;
	private String stype;
	private String sname;
	private String semail;
	private Integer slicense;
	private Integer sphone;
	private Integer status;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getsaccounts() {
		return saccounts;
	}
	public void setsaccounts(Integer saccounts) {
		this.saccounts = saccounts;
	}
	public String getSshopname() {
		return sshopname;
	}
	public void setSshopname(String sshopname) {
		this.sshopname = sshopname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public Integer getSlicense() {
		return slicense;
	}
	public void setSlicense(Integer slicense) {
		this.slicense = slicense;
	}
	public Integer getSphone() {
		return sphone;
	}
	public void setSphone(Integer sphone) {
		this.sphone = sphone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
}
