package meituan.po;

public class GoodsInfoPo {
	private int gid;					//商品详情表编号
//	private String gidentifier;			//商品号
	private String gdate;				//上架时间
	private String privilege;			//优惠
	private int sid;					//商家号
	private String gtitle1;				//主标题
	private String gtitle2;				//副标题
	private float gprice1;				//原价
	private float gprice2;				//现价
	private int gsoldcount;			//已购数
	private String img;					//图片信息
	private String text;//文字描述
	private int temp1;//状态
	private String temp2;
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	public int getTemp1() {
		return temp1;
	}
	public void setTemp1(int temp1) {
		this.temp1 = temp1;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
//	public String getGidentifier() {
//		return gidentifier;
//	}
//	public void setGidentifier(String gidentifier) {
//		this.gidentifier = gidentifier;
//	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getGtitle1() {
		return gtitle1;
	}
	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}
	public String getGtitle2() {
		return gtitle2;
	}
	public void setGtitle2(String gtitle2) {
		this.gtitle2 = gtitle2;
	}
	public float getGprice1() {
		return gprice1;
	}
	public void setGprice1(float gprice1) {
		this.gprice1 = gprice1;
	}
	public float getGprice2() {
		return gprice2;
	}
	public void setGprice2(float gprice2) {
		this.gprice2 = gprice2;
	}
	public int getGsoldcount() {
		return gsoldcount;
	}
	public void setGsoldcount(int gsoldcount) {
		this.gsoldcount = gsoldcount;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public GoodsInfoPo(int gid, String gdate, String privilege, int sid,
			String gtitle1, String gtitle2, float gprice1, float gprice2,
			int gsoldcount, String img, String text, int temp1,String temp2) {
		super();
		this.gid = gid;
		this.gdate = gdate;
		this.privilege = privilege;
		this.sid = sid;
		this.gtitle1 = gtitle1;
		this.gtitle2 = gtitle2;
		this.gprice1 = gprice1;
		this.gprice2 = gprice2;
		this.gsoldcount = gsoldcount;
		this.img = img;
		this.text = text;
		this.temp1 = temp1;
		this.temp2=temp2;
	}
	public GoodsInfoPo() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "GoodsInfoPo [gid=" + gid + ", gdate=" + gdate + ", privilege="
				+ privilege + ", sid=" + sid + ", gtitle1=" + gtitle1
				+ ", gtitle2=" + gtitle2 + ", gprice1=" + gprice1
				+ ", gprice2=" + gprice2 + ", gsoldcount=" + gsoldcount
				+ ", img=" + img + ", text=" + text + ", temp1=" + temp1
				+ ", temp2=" + temp2 + "]";
	}
}
