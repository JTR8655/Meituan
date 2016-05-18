package meituan.biz.bizImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import meituan.biz.IUserFunctionBiz;
import meituan.dao.DBHelper;
import meituan.vo.NoEvalVo;

public class UserFunctionBizImpl implements IUserFunctionBiz {
	DBHelper db=new DBHelper();
	
	/**
	 * 查看所有订单
	 * @param muid
	 * @return
	 */
	public List<Map<String,Object>> showAllOrder(int muid){
		String sql = "select * from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid where muid = ? order by opaytime desc";
		List<Object> params = new ArrayList<Object>();
		params.add(muid);
		return db.select(sql, params);
	}
	
	/**
	 * 用户订单评价，龙振宇
	 */
	@Override
	public int uPingjia(List<Object> param1) {
		int result=0;
	//	String sql="insert into meituan_evaluate (eid,muid,oid,egrade_1,egrade_2,egrade_3,egrade_4,econtent,img,hidename) values(?,?,?,?,?,?,?,?,?,?)";
		List<String>sqls=new ArrayList<String>();
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = format.format(date);
		String sql1="insert into meituan_evaluate (eid,muid,oid,egrade_1,econtent,hidename,temp1) values(?,?,?,?,?,?,?)";
		String sql2="update meituan_uorder set PJSTATUS =1 where oid=? and muid = ?";
		sqls.add(sql1);
		sqls.add(sql2);
		List<Object>param2=new ArrayList<Object>();
		List<List<Object>>params=new ArrayList<List<Object>>();
		param2.add(param1.get(2));
		param2.add(param1.get(1));
		param1.add(time);
		params.add(param1);
		params.add(param2);
		System.out.println("params:::::"+params);
		try {
			result=db.doUpdate(sqls, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 显示未评价订单，龙振宇
	 */
	@Override
	public List<NoEvalVo> showNoEvaList(int muid) {
		String sql="select * from noeval where muid=?";
		System.out.println("muid:"+muid);
		List<Object>param=new ArrayList<Object>();
		param.add(muid);
		List<NoEvalVo> list = null;
		list= db.find(sql, param, NoEvalVo.class);
		return list;
	}

	public List<Map<String,Object>> showCollection_1() {
		String sql = "select m.gid, g.img, g.gtitle1, g.gprice2, m.cstatus from meituan_collection m inner join meituan_goods_info g on m.gid = g.gid ";
		return db.select(sql, null);
	}

	public List<Map<String,Object>> showCollection_2() {
		String sql = "select m.gid, g.img, g.gtitle1, g.gprice2, m.cstatus from meituan_collection m inner join" +
				" meituan_goods_info g on m.gid = g.gid where m.cstatus = '进行中'";
		return db.select(sql, null);
	}
	
	public List<Map<String,Object>> showCollection_3() {
		String sql = "select m.gid, g.img, g.gtitle1, g.gprice2, m.cstatus from meituan_collection m inner join" +
				" meituan_goods_info g on m.gid = g.gid where m.cstatus = '已结束'";
		return db.select(sql, null);
	}

	@Override
	public int deleteCollection(String gid) {
		int result = 0;
		String sql = "delete from meituan_collection where gid = ?";
		//String sql = "delete from meituan_collection where gid = ? and muid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(gid);
		result = db.update(sql, params);
		return result;
	}

	public List<Map<String,Object>> showEvaluated(int muid){
		String sql = "select * from meituan_evaluate e inner join meituan_uorder o on e.oid = o.oid inner join meituan_goods_info g on g.gid = o.gid and e.muid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(muid);
		System.out.println(95+"\nsql:"+sql+"\nparams:"+params);
		return db.select(sql, params);
	}
	
	
	

}
