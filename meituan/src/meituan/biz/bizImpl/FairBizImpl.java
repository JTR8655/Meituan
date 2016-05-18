package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;

import meituan.biz.IFairBiz;
import meituan.dao.DBHelper;
import meituan.po.UorderPo;

public class FairBizImpl implements IFairBiz {
	DBHelper db=new DBHelper();
	
	@Override
	public int cart(UorderPo po) {	
		
		String sql = "insert into meituan_uorder values(seq_oid.nextval, ?, ?, ?, sysdate, '未消费', ?, sysdate, ?, '0', '')";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getOidentifier());
		params.add(po.getMuid());
		params.add(po.getGid());
		params.add(po.getOpwd());
		params.add(po.getOcount());
		return db.update(sql, params);
	}

}
