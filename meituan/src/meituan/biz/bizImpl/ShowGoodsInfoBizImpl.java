package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meituan.biz.IShowGoodsInfoBiz;
import meituan.dao.DBHelper;
import meituan.po.GoodsIntroPo;

public class ShowGoodsInfoBizImpl implements IShowGoodsInfoBiz {

	DBHelper db = new DBHelper();
	@Override
	public List<Map<String, Object>> showGoods(int gid) {
		String sql = "select g.gid, s.sshopname,s.sid, g.gtitle1, g.img, g.text, g.gsoldcount, g.gprice1, g.gprice2, m.b_retime, m.d_taocan from meituan_seller_info s inner join meituan_goods_info g on s.sid = g.sid inner join meituan_goods_intro m on g.gid = m.gid and g.gid = ?";
		List<Object> params=new ArrayList<Object>();
		params.add(gid);
		return db.select(sql, params);
	}
	@Override
	public List<GoodsIntroPo> must_know() {
		String sql = "select b_retime, b_ordertip, b_parlor, b_pack, b_serve, b_limittip, d_taocan, d_price1, d_count from meituan_goods_intro";
		return db.find(sql, null, GoodsIntroPo.class);
	}
	@Override
	public List<Map<String, Object>> showEvaluatePoint(int gid) {
		String sql ="select sum(egrade_1) grade, count(egrade_1) amount from meituan_evaluate e inner join meituan_uorder o on e.oid=o.oid and o.gid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(gid);
		return db.select(sql, params);
	}
	@Override
	public List<Map<String, Object>> otherFoods(String sid) {
		String sql = "select s.sshopname,g.gid, g.text, g.gprice1, g.gprice2, g.gsoldcount, round((g.gprice2/g.gprice1)*10,1) discount from meituan_seller_info s inner join meituan_goods_info g on s.sid = g.sid where g.sid = ?";
		List<Object> params=new ArrayList<Object>();
		params.add(sid);
		System.out.println("sql:"+sql);
		System.out.println("sid:"+sid);
		return db.select(sql, params);
	}
	@Override
	public List<Map<String, Object>> showEvaluateContent(int gid) {
		String sql = "select u.uaccounts, u.uheadimg, e.egrade_1, e.econtent, e.temp1 from meituan_user_info u inner join meituan_evaluate e on u.muid = e.muid inner join meituan_uorder o on e.oid=o.oid and o.gid= ?";
		List<Object> params=new ArrayList<Object>();
		params.add(gid);
		System.out.println("gid::"+gid);
		return db.select(sql, params);
	}

}
