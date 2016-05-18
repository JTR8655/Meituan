package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meituan.biz.IIndexGoodsBiz;
import meituan.dao.DBHelper;
import meituan.po.CollectionPo;
import meituan.po.GoodsInfoPo;

public class IndexGoodsBizImpl implements IIndexGoodsBiz{

	DBHelper db = new DBHelper();
	@Override
	public List<GoodsInfoPo> showDetail() {
		String sql = "select gid, gtitle1, img, text, gprice1, gprice2, gsoldcount from meituan_goods_info";
		return db.find(sql, null, GoodsInfoPo.class);
	}
	@Override
	public int collectGoods(String gid,int muid) {
		int result = 0;
		String checkSql="select * from meituan_collection where muid = ? and gid = ?;";
		String sql = "insert into meituan_collection values(seq_collection.nextval, ?, ?, '进行中')";
		List<Object> checkParams = new ArrayList<Object>();
		checkParams.add(muid);
		checkParams.add(gid);
		if(muid!=0){
			List<CollectionPo> collection = db.find(checkSql, checkParams, CollectionPo.class);
			if(null == collection || collection.size()<=0){
				List<Object> params = new ArrayList<Object>();	
				params.add(muid);
				params.add(gid);
				result = db.update(sql, params);
			}else{
				result = -1;
			}
		}else{
			result = -1;
		}
		
		return result;
	}
	@Override
	public List<Map<String, Object>> checkCollection(String gid) {
		//String muid
		//String sql = "select gid from meituan_collection where gid = ? and muid = ?";
		String sql = "select gid from meituan_collection where gid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(gid);
		//params.add(muid);
		return db.select(sql, params);
	}
	@Override
	public List<Map<String, Object>> showCollection() {
		String sql = "select gid from meituan_collection";
		//String sql = "select gid, muid from meituan_collection";
		return db.select(sql, null);
	}

}
