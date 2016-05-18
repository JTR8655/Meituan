package meituan.po;

public class SellerPo {
	private int sid;				//商家表编号，主键
	private String saccounts;			//商家帐号
	private String spwd;			//密码
	private String saddress;		//地址
	private String sshopname;		//店铺名
	private String stype;			//营销类型
	private String sname;			//姓名	
	private String semail;			//邮箱
	private String slicense;		//营业执照
	private String  sphone;			//手机
	private int status;			//权限状态
	private String temp1;
	private String temp2;
	
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSaccounts() {
		return saccounts;
	}
	public void setSaccounts(String saccounts) {
		this.saccounts = saccounts;
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
	public String getSshopname() {
		return sshopname;
	}
	public void setSshopname(String sshopname) {
		this.sshopname = sshopname;
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
	public String getSlicense() {
		return slicense;
	}
	public void setSlicense(String slicense) {
		this.slicense = slicense;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	@Override
	public String toString() {
		return "SellerPo [sid=" + sid + ", saccounts=" + saccounts + ", spwd="
				+ spwd + ", saddress=" + saddress + ", sshopname=" + sshopname
				+ ", stype=" + stype + ", sname=" + sname + ", semail="
				+ semail + ", slicense=" + slicense + ", sphone=" + sphone
				+ ", status=" + status + ", temp1=" + temp1 + ", temp2="
				+ temp2 + "]";
	}
	public SellerPo(int sid, String saccounts, String spwd, String saddress,
			String sshopname, String stype, String sname, String semail,
			String slicense, String sphone, int status, String temp1,
			String temp2,String message) {
		super();
		this.sid = sid;
		this.saccounts = saccounts;
		this.spwd = spwd;
		this.saddress = saddress;
		this.sshopname = sshopname;
		this.stype = stype;
		this.sname = sname;
		this.semail = semail;
		this.slicense = slicense;
		this.sphone = sphone;
		this.status = status;
		this.temp1 = temp1;
		this.temp2 = temp2;

	}
	public SellerPo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
