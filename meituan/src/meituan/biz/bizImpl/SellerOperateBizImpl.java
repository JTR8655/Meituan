package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;






import meituan.biz.ISellerOperateBiz;
import meituan.commons.MD5Encryption;
import meituan.dao.DBHelper;
import meituan.po.GoodsInfoPo;
import meituan.po.GoodsIntroPo;
import meituan.po.SellerPo;

public class SellerOperateBizImpl implements ISellerOperateBiz {
	private DBHelper db=new DBHelper();
	


	/**
	 * 商家登录
	 */
	@Override
	public List<SellerPo> sLogin(SellerPo seller) {
		List<SellerPo> po=new ArrayList<SellerPo>();
		String sql="select * from meituan_seller_info where saccounts=? and spwd=? and status =1";
		List<Object>params=new ArrayList<Object>();
		params.add(seller.getSaccounts());
		//params.add(MD5Encryption.createPassword(seller.getSpwd()));
		params.add(seller.getSpwd());
		return db.find(sql, params, SellerPo.class);
		
	}
	

	public 	List<GoodsInfoPo> getGoodsCount() {
		String sql="select * from meituan_goods_info";
		List<GoodsInfoPo>list=db.find(sql, null, GoodsInfoPo.class);
		return list;
	}
	/**
	 *查看商家个人信息
	 */
	public 	List<SellerPo> findBySaccounts(SellerPo po){
		String sql="select * from meituan_seller_info where saccounts=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getSaccounts());
		return db.find(sql, params, SellerPo.class);
	}
	
	public List<SellerPo> findBypage(Integer pageNo, Integer pageSize,String saccounts) {
		String sql="select * from (select a.*,rownum rn from (select * from meituan_seller_info where saccounts=? order by saccounts ) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(saccounts);
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, SellerPo.class);
	}
	//查询商品信息
	public List<GoodsInfoPo> findAllBypage(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.*,rownum rn from (select * from meituan_goods_view) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, GoodsInfoPo.class);
		
	}
	/**
	 * 商家注册
	 */
	@Override
	public Boolean addSellerPo(SellerPo seller) {
		String sql="insert into meituan_seller_info values(seq_meituanseller.nextval,null,?,?,?,?,?,?,?,?,default,null,null)";
		List<Object> params=new ArrayList<Object>();
		
		params.add(MD5Encryption.createPassword(seller.getSpwd()));
		params.add(seller.getSaddress());
		params.add(seller.getSshopname());
		params.add(seller.getStype());
		params.add(seller.getSname());
		params.add(seller.getSemail());
		params.add(seller.getSlicense());
		params.add(seller.getSphone());
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}




/**
 * 修改个人信息
 * @param seller
 * @return
 */
	public boolean updateAdmin(SellerPo seller) {
		String sql="update meituan_seller_info set spwd=?,sphone=? where saccounts=?";
		List<Object> params = new ArrayList<Object>();
		params.add(seller.getSpwd());
		params.add(seller.getSphone());
		params.add(seller.getSaccounts());
		
		
	 db.update(sql, params);
	 return true;
	}
	//获取商品详情表中的信息总数
	public int getCount1(String saccounts) {
		String sql="select count(*) from meituan_seller_info where saccounts=?";
		List<Object> params = new ArrayList<Object>();
		params.add(saccounts);
		int num=(int)db.selectPloymer(sql, params);
		return num;
	}
	//获取商家表中的信息总数
	public int getCount() {
		String sql="select count(*) from meituan_goods_info";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}
	
	//获取商家商品附加信息表中的所有信息总数
	public int getCount2(String saccounts) {
		String sql="select count(*) from meituan_goods_intro";
//		List<Object> params = new ArrayList<Object>();
//		params.add(saccounts);
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}

	public List<SellerPo> findBypage(int parseInt, int parseInt2,
			List<GoodsInfoPo> goods) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */

	public boolean updateGoods(GoodsInfoPo goods) {
		String sql=" update meituan_goods_info set privilege=?,gtitle1=?,gtitle2=?,gprice1=?,gprice2=?,img=?,text=?,temp1=? where gid=?"; 
		List<Object> ob = new ArrayList<Object>();
		ob.add(goods.getPrivilege());
		ob.add(goods.getGtitle1());
		ob.add(goods.getGtitle2());
		ob.add(goods.getGprice1());
		ob.add(goods.getGprice2());
		ob.add(goods.getImg());
		ob.add(goods.getText());
		ob.add(goods.getTemp1());
		ob.add(goods.getGid());
	//	System.out.println("goods:"+goods);
		
		
		 db.update(sql, ob);
		 return true;
	}
	
	//添加商品信息
	public boolean add(GoodsInfoPo po) {
		String sql="insert into meituan_goods_info values(?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?,?,default,?,?,default,null)";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getGid());
		params.add(po.getGdate());
		params.add(po.getPrivilege());
		params.add(po.getSid());
		params.add(po.getGtitle1());
		params.add(po.getGtitle2());
		params.add(po.getGprice1());
		params.add(po.getGprice2());
		//params.add(po.getGsoldcount());
		params.add(po.getImg());
		params.add(po.getText());
		//params.add(po.getTemp1());
		//params.add(po.getTemp2());
//		System.out.println("params:"+params);
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}
public 	List<GoodsIntroPo> getGoodsCount1() {
		
		String sql="select * from meituan_goods_intro";
		List<GoodsIntroPo>list1=db.find(sql, null, GoodsIntroPo.class);
		
		return list1;
		}
	
	//查询商品附加信息
	public List<GoodsIntroPo> findAllGoodsIntroBypage(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.*,rownum rn from (select * from meituan_goods_intro_view) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, GoodsIntroPo.class);
		
	}

	//添加商品附加信息
	public boolean add(GoodsIntroPo po) {
		String sql="insert into meituan_goods_intro values(?,?,?,?,default,default,default,default,default,default,?,?,?,'','','')";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getGid());
		params.add(po.getSid());
		params.add(po.getB_retime());
		params.add(po.getB_usetime());
		//params.add(po.getB_ordertip());
		//params.add(po.getB_parlor());
		//params.add(po.getB_pack());
		//params.add(po.getB_serve());
		//params.add(po.getB_limittip());
		//params.add(po.getB_prompt());
		params.add(po.getD_taocan());
		params.add(po.getD_price1());
		params.add(po.getD_count());
		
		System.out.println("params:"+params);
		
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}
	//修改商品附加信息
	public boolean updateGoodsIntro(GoodsIntroPo goods) {
		String sql=" update meituan_goods_intro set b_retime=?,b_usetime=?,b_ordertip=?,b_parlor=?,b_pack=?,b_serve=?,b_limittip=?,b_prompt=?,d_taocan=?,d_price1=?,d_count=? where gid=?"; 
		List<Object> ob = new ArrayList<Object>();
		//ob.add(goods.getSid());
		ob.add(goods.getB_retime());
		ob.add(goods.getB_usetime());
		ob.add(goods.getB_ordertip());
		ob.add(goods.getB_parlor());
		ob.add(goods.getB_pack());
		ob.add(goods.getB_serve());
		ob.add(goods.getB_limittip());
		ob.add(goods.getB_prompt());
		ob.add(goods.getD_taocan());
		ob.add(goods.getD_price1());
		ob.add(goods.getD_count());
		ob.add(goods.getGid());
	//	System.out.println("goods:"+goods);
		
		
		 db.update(sql, ob);
		 return true;
	}
	
	
	

}
