package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;

import meituan.biz.ISellerOperateBiz;
import meituan.dao.DBHelper;
import meituan.po.GoodsInfoPo;
import meituan.po.GoodsIntroPo;
import meituan.po.GoodsOrderPo;
import meituan.po.SellerPo;

public class SellerGoodsOrderBizImpl{
	private DBHelper db=new DBHelper();
	
	/**
	 * 查订单信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<GoodsOrderPo> findAllGoodsOrderBypage(Integer sid,Integer pageNo, Integer pageSize) {			//and o.opwd like '%?%'
		String sql="select * from (select a.*,rownum rn from (select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid and g.sid = ?  and o.ostatus='未消费') a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		
		params.add(sid);
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		
		return db.find(sql, params, GoodsOrderPo.class);
	
		
	}
	/**
	 * 更改订单状态
	 * @return
	 */

	public boolean updateOrder(GoodsOrderPo orders) {
		String sql="update meituan_uorder set ostatus='已消费' where opwd like '%?%' ";

		List<Object> ob = new ArrayList<Object>();
		ob.add(orders.getOstatus());
		 db.update(sql, ob);
		 return true;
	}
	
	public List<GoodsOrderPo> getGoodsCount1(int sid ) {
		String sql="select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid and g.sid = ? and  o.ostatus='未消费'";
		List<Object> params = new ArrayList<Object>();
		params.add(sid);
		List<GoodsOrderPo> list = db.find(sql, params , GoodsOrderPo.class);
		return list;
	}

	public int getCount(int sid) {
		String sql=" select count(*) from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid and g.sid = ?  and o.ostatus='未消费'";
		List<Object> params = new ArrayList<Object>();
		params.add(sid);
		int num=(int) db.selectPloymer(sql, params);
		return num;
	}
	


}
