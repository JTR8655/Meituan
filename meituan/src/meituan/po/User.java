package meituan.po;

public class User {
	private Integer muid;				//会员编号，主键
	private String uaccounts;		//用户帐号
	private String upwd;			//密码
	private String uemail;			//邮箱
	private String uphone;			//手机
	private String usex;			//性别
	private float ubalance;		//余额
	private Integer upoint;			//积分
	private String ubirth;			//生日
	private String umarital;		//个人状况，已婚未婚
	private String ujob;			//身份|职业
	private String uheadimg;		//头像信息
	private String uinterest;		//兴趣
	private Integer ustatus;			//激活状态，规定时间未激活则删除该数据,0表示未激活
	private String uaddr;
	private String temp2;
	
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
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
		this.uaccounts = uaccounts;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public float getUbalance() {
		return ubalance;
	}
	public void setUbalance(float ubalance) {
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
		this.umarital = umarital;
	}
	public String getUjob() {
		return ujob;
	}
	public void setUjob(String ujob) {
		this.ujob = ujob;
	}
	public String getUheadimg() {
		return uheadimg;
	}
	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}
	public String getUinterest() {
		return uinterest;
	}
	public void setUinterest(String uinterest) {
		this.uinterest = uinterest;
	}
	public Integer getUstatus() {
		return ustatus;
	}
	public void setUstatus(Integer ustatus) {
		this.ustatus = ustatus;
	}
	
	public User(Integer muid, String uaccounts, String upwd, String uemail,
			String uphone, String usex, float ubalance, Integer upoint, String ubirth,
			String umarital, String ujob, String uheadimg, String uinterest,
			Integer ustatus,String uaddr,String temp2) {
		this.muid = muid;
		this.uaccounts = uaccounts;
		this.upwd = upwd;
		this.uemail = uemail;
		this.uphone = uphone;
		this.usex = usex;
		this.ubalance = ubalance;
		this.upoint = upoint;
		this.ubirth = ubirth;
		this.umarital = umarital;
		this.ujob = ujob;
		this.uheadimg = uheadimg;
		this.uinterest = uinterest;
		this.ustatus = ustatus;
		this.uaddr=uaddr;
		this.temp2=temp2;
	}
	
	public User(){
	
	}
	@Override
	public String toString() {
		return "User [muid=" + muid + ", uaccounts=" + uaccounts + ", upwd="
				+ upwd + ", uemail=" + uemail + ", uphone=" + uphone
				+ ", usex=" + usex + ", ubalance=" + ubalance + ", upoint="
				+ upoint + ", ubirth=" + ubirth + ", umarital=" + umarital
				+ ", ujob=" + ujob + ", uheadimg=" + uheadimg + ", uinterest="
				+ uinterest + ", ustatus=" + ustatus + ", uaddr=" + uaddr + ", temp2=" + temp2 +"]";
	}

}
