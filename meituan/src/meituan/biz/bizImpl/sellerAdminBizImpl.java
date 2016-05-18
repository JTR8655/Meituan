package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;

import meituan.biz.IAdminBiz;
import meituan.commons.MD5Encryption;
import meituan.dao.DBHelper;
import meituan.po.sellerAdminPO;

public class sellerAdminBizImpl implements IAdminBiz{
	DBHelper db=new DBHelper();
	@Override//获取登录
	public sellerAdminPO login(sellerAdminPO po) {
		String sql="select saccounts,spwd from meituan_seller_info where saccounts=? and spwd=? and status=1";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getSname());
		params.add(MD5Encryption.createPassword(po.getSpwd()));
		List<sellerAdminPO> list=db.find(sql, params,sellerAdminPO.class);
		System.out.println(list.size());
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public List<sellerAdminPO> findBypage(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.*,rownum rn from (select * from admin order by aid) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, sellerAdminPO.class);
		
	}
	@Override
	public double getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean addAdmin(sellerAdminPO po) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateAdmin(sellerAdminPO po) {
		String sql="";
		List<Object> params=new ArrayList<Object>();
		sql="update meituan_seller_info set spwd=? where sid=?";
		params.add(MD5Encryption.createPassword(po.getSpwd()));
		params.add(po.getSid());
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}
	//删除管理员 一次删除多条记录，所以页面传过来的是aid的字符串拼接1001，,1002,1003
	@Override
	public boolean deleteAdmin(String aids){
	
		List<List<Object>> params=new ArrayList<List<Object>>();
		List<Object> param=new ArrayList<Object>();
		List<String> sqls=new ArrayList<String>();
		if(null!=aids&&!"".equals(aids)){
			String  [] str=aids.split(",");
			String sql="delete from  meituan_seller_info where saccounts=?";
			if(str.length>0){
				for(String aid:str){
					param=new ArrayList<Object>();
					param.add(aid);
					params.add(param);
					sqls.add(sql);
				}
			}
		}
		try {
			int i=db.doUpdate(sqls, params);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
