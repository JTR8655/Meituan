package meituan.po;

public class ManagerPo {
	private Integer mid;
	private String mname;
	private String mpwd;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public ManagerPo(Integer mid, String mname, String mpwd) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpwd = mpwd;
	}
	public ManagerPo() {
		super();
	}

}
