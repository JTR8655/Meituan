package meituan.po;

public class EvaluatePo {
	private Integer eid;				//评价表编号
	private Integer muid;				//会员编号
	private Integer oid;				//订单编号
	private float egrade_1;		//服务分
	private float egrade_2;		//口味分
	private float egrade_3;		//环境分
	private float egrade_4;		//总评分
	private String econtent;		//评价内容
	private String img;				//图片
	private Integer hidename;			//匿名状态
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getMuid() {
		return muid;
	}
	public void setMuid(Integer muid) {
		this.muid = muid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public float getEgrade_1() {
		return egrade_1;
	}
	public void setEgrade_1(float egrade_1) {
		this.egrade_1 = egrade_1;
	}
	public float getEgrade_2() {
		return egrade_2;
	}
	public void setEgrade_2(float egrade_2) {
		this.egrade_2 = egrade_2;
	}
	public float getEgrade_3() {
		return egrade_3;
	}
	public void setEgrade_3(float egrade_3) {
		this.egrade_3 = egrade_3;
	}
	public float getEgrade_4() {
		return egrade_4;
	}
	public void setEgrade_4(float egrade_4) {
		this.egrade_4 = egrade_4;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getHidename() {
		return hidename;
	}
	public void setHidename(Integer hidename) {
		this.hidename = hidename;
	}
	@Override
	public String toString() {
		return "Evaluate [eid=" + eid + ", muid=" + muid + ", oid=" + oid
				+ ", egrade_1=" + egrade_1 + ", egrade_2=" + egrade_2
				+ ", egrade_3=" + egrade_3 + ", egrade_4=" + egrade_4
				+ ", econtent=" + econtent + ", img=" + img + ", hidename="
				+ hidename + "]";
	}
	public EvaluatePo(Integer eid, Integer muid, Integer oid, float egrade_1, float egrade_2,
			float egrade_3, float egrade_4, String econtent, String img,
			Integer hidename) {
		super();
		this.eid = eid;
		this.muid = muid;
		this.oid = oid;
		this.egrade_1 = egrade_1;
		this.egrade_2 = egrade_2;
		this.egrade_3 = egrade_3;
		this.egrade_4 = egrade_4;
		this.econtent = econtent;
		this.img = img;
		this.hidename = hidename;
	}
	public EvaluatePo() {
		super();
	}
}
