package meituan.vo;

public class NoEvalVo {
	
	private Integer oid;
	private Integer gid;
	private Integer muid;
	private String gtitle1;
	private String img;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getMuid() {
		return muid;
	}
	public void setMuid(Integer muid) {
		this.muid = muid;
	}
	public String getGtitle1() {
		return gtitle1;
	}
	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public NoEvalVo(Integer oid, Integer gid, Integer muid, String gtitle1,
			String img) {
		super();
		this.oid = oid;
		this.gid = gid;
		this.muid = muid;
		this.gtitle1 = gtitle1;
		this.img = img;
	}
	public NoEvalVo() {
		super();
	}
	
		
}
