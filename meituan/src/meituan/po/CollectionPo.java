package meituan.po;

public class CollectionPo {
	private Integer cid;			//收藏编号
	private Integer muid;			//会员编号
	private Integer gid;			//商品编号
	private String cstatus;		//状态：进行中，已结束
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
		this.cstatus = cstatus;
	}
	@Override
	public String toString() {
		return "Collection [cid=" + cid + ", muid=" + muid + ", gid=" + gid
				+ ", cstatus=" + cstatus + "]";
	}
	public CollectionPo(Integer cid, Integer muid, Integer gid, String cstatus) {
		super();
		this.cid = cid;
		this.muid = muid;
		this.gid = gid;
		this.cstatus = cstatus;
	}
	public CollectionPo() {
		super();
	}
	
}
