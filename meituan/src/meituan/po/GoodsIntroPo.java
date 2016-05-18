package meituan.po;

public class GoodsIntroPo {

	public GoodsIntroPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int gid;                //商品介绍表编号
	private String gtitle1;
	public String getGtitle1() {
		return gtitle1;
	}
	public void setGtitle1(String gtitle1) {
		this.gtitle1 = gtitle1;
	}
	private int sid;				//商家号	
	
	private String b_retime;		//有效期
	private String b_usetime;		//使用时间
	private String b_ordertip;		//预约提示
	private String b_parlor;		//包间
	private String b_pack;			//食堂外带
	private String b_serve;			//商家服务
	private String b_limittip;		//限购限用提醒
	private String b_prompt;		//温馨提示
	private String d_taocan;		//套餐内容
	private float d_price1;			//单价
	private int d_count;			//数量
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getB_retime() {
		return b_retime;
	}
	public void setB_retime(String b_retime) {
		this.b_retime = b_retime;
	}
	public String getB_usetime() {
		return b_usetime;
	}
	public void setB_usetime(String b_usetime) {
		this.b_usetime = b_usetime;
	}
	public String getB_ordertip() {
		return b_ordertip;
	}
	public void setB_ordertip(String b_ordertip) {
		this.b_ordertip = b_ordertip;
	}
	public String getB_parlor() {
		return b_parlor;
	}
	public void setB_parlor(String b_parlor) {
		this.b_parlor = b_parlor;
	}
	public String getB_pack() {
		return b_pack;
	}
	public void setB_pack(String b_pack) {
		this.b_pack = b_pack;
	}
	public String getB_serve() {
		return b_serve;
	}
	public void setB_serve(String b_serve) {
		this.b_serve = b_serve;
	}
	public String getB_limittip() {
		return b_limittip;
	}
	public void setB_limittip(String b_limittip) {
		this.b_limittip = b_limittip;
	}
	public String getB_prompt() {
		return b_prompt;
	}
	public void setB_prompt(String b_prompt) {
		this.b_prompt = b_prompt;
	}

	public String getD_taocan() {
		return d_taocan;
	}
	public void setD_taocan(String d_taocan) {
		this.d_taocan = d_taocan;
	}
	public float getD_price1() {
		return d_price1;
	}
	public void setD_price1(float d_price1) {
		this.d_price1 = d_price1;
	}
	public int getD_count() {
		return d_count;
	}
	public void setD_count(int d_count) {
		this.d_count = d_count;
	}
	@Override
	public String toString() {
		return "GoodsIntroPo [gid=" + gid + ", gtitle1=" + gtitle1 + ", sid="
				+ sid + ", b_retime=" + b_retime + ", b_usetime=" + b_usetime
				+ ", b_ordertip=" + b_ordertip + ", b_parlor=" + b_parlor
				+ ", b_pack=" + b_pack + ", b_serve=" + b_serve
				+ ", b_limittip=" + b_limittip + ", b_prompt=" + b_prompt
				+ ", d_taocan=" + d_taocan + ", d_price1=" + d_price1
				+ ", d_count=" + d_count + "]";
	}
	
	public GoodsIntroPo(int gid, String gtitle1, int sid, String b_retime,
			String b_usetime, String b_ordertip, String b_parlor,
			String b_pack, String b_serve, String b_limittip, String b_prompt,
			String d_taocan, float d_price1, int d_count) {
		super();
		this.gid = gid;
		this.gtitle1 = gtitle1;
		this.sid = sid;
		this.b_retime = b_retime;
		this.b_usetime = b_usetime;
		this.b_ordertip = b_ordertip;
		this.b_parlor = b_parlor;
		this.b_pack = b_pack;
		this.b_serve = b_serve;
		this.b_limittip = b_limittip;
		this.b_prompt = b_prompt;
		this.d_taocan = d_taocan;
		this.d_price1 = d_price1;
		this.d_count = d_count;
	}
}
