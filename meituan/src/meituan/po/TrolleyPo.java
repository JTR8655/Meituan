package meituan.po;

public class TrolleyPo {
	private Integer tid;			//购物车编号
	private Integer muid;			//会员编号
	private Integer gid;			//商品编号
	private Integer tcount;		//数量
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
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
	public Integer getTcount() {
		return tcount;
	}
	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}
	@Override
	public String toString() {
		return "Trolley [tid=" + tid + ", muid=" + muid + ", gid=" + gid
				+ ", tcount=" + tcount + "]";
	}
	public TrolleyPo(Integer tid, Integer muid, Integer gid, Integer tcount) {
		super();
		this.tid = tid;
		this.muid = muid;
		this.gid = gid;
		this.tcount = tcount;
	}
	public TrolleyPo() {
		super();
	}
	
}
