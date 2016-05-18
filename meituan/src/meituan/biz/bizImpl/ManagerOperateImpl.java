package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meituan.biz.ImanagerBiz;
import meituan.commons.MD5Encryption;
import meituan.dao.DBHelper;
import meituan.po.ManagerPo;
import meituan.po.SellerPo;
import meituan.po.User;

public class ManagerOperateImpl implements ImanagerBiz{
	private DBHelper db=new DBHelper();
	
	/**
	 * 登录
	 */
	@Override
	public ManagerPo login(ManagerPo po) {
		String sql="select mid,mname,mpwd from meituan_manager where mname=? and mpwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getMname());
		params.add(MD5Encryption.createPassword(po.getMpwd()));
		List<ManagerPo> man=db.find(sql, params, ManagerPo.class);
		if(man!=null && man.size()>0){
			return man.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 查询所有
	 */
	@Override
	public int total() {
		String sql="select count(mid) from meituan_manager";
		return (int)db.selectPloymer(sql, null);
	}
	/**
	 * 分页查询管理员信息
	 */
	@Override
	public List<ManagerPo> find(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.* ,rownum rn from (select * from meituan_manager m order by mid) a where rownum<?) b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, ManagerPo.class);
	}
	@Override
	public Boolean addAdminInfo(ManagerPo po) {
		String sql="insert into meituan_manager values(seq_manager.nextval,?,?,null)";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getMname());
		params.add(MD5Encryption.createPassword(po.getMpwd()));		
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int updateAdminInfo(ManagerPo po) {
		String sql="update meituan_manager set mname =?, mpwd=? where  mid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getMname());
		params.add(MD5Encryption.createPassword(po.getMpwd()));
		params.add(po.getMid());
		return db.update(sql,params);
	}
	@Override
	public int delAdminInfo(String mid) {
		List<Object> params=new ArrayList<Object>();
		String sql;
		if(mid.contains(",") && mid.indexOf("or")<=0){ //说明同时删除多个
			sql="delete from meituan_manager where mid in("+mid+")";
		}else{
			sql="delete from meituan_manager where mid=?";
			params.add(mid);
		}
		return db.update(sql, params);
	}
	
	//分页 查询未激活商家   select sid,saccounts,saddress,sshopname,sname,semail,slicense,sphone,status from meituan_seller_info;
	@Override
	public List<SellerPo> findAlive(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.*,rownum rn from (select * from meituan_seller_info where status=0 and slicense='1' order by sid ) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		System.out.println("params:"+params);
		return db.find(sql, params, SellerPo.class);
		
	}
	//查询所有
	@Override
	public int all() {
		String sql="select count(sid) from meituan_seller_info";
		return (int)db.selectPloymer(sql, null);
	}
	
	//激活商家
	@Override
	public int activeShop(int sid,int status) {
		String sql="update meituan_seller_info set status=? where sid=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(status);
		params.add(sid);
		return db.update(sql,params);
	}
	
	@Override
	public int delUserinfo(String muid) {
		List<Object> params=new ArrayList<Object>();
		String sql;
		if(muid.contains(",") && muid.indexOf("or")<=0){ //说明同时删除多个
			sql="delete from meituan_user_info where muid in("+muid+")";
		}else{
			sql="delete from meituan_user_info where muid=?";
			params.add(muid);
		}
		return db.update(sql, params);
	}
	//分页查询用户信息
	@Override
	public List<User> findUser(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.* ,rownum rn from (select * from meituan_user_info m order by muid) a where rownum<?) b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, User.class);
	}
	@Override
	public int allUser() {
		String sql="select count(muid) from meituan_user_info";
		return (int)db.selectPloymer(sql, null);
	}
	
	//查询已激活商家
	@Override
	public List<SellerPo> findAAlive(Integer pageNo, Integer pageSize) {
		String sql="select * from (select a.*,rownum rn from (select * from meituan_seller_info where status=1 and slicense='1' order by sid ) a where rownum<=?)b where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, SellerPo.class);
	}
	@Override
	public int findUorder(String sid) {
		String sql="select sum(mo.ocount) from meituan_uorder mo,meituan_goods_info mg ,meituan_seller_info ms where mg.gid=mo.gid  and mg.sid=ms.sid and mg.sid=?  and mo.ostatus='已使用'";
		List<Object> params=new ArrayList<Object>();
		params.add(sid);
		return (int)db.selectPloymer(sql, null);
	}
	
	@Override
	public List<SellerPo> findName(String sid) {
		String sql="select sshopname from meituan_seller_info where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(sid);
		return db.find(sql, params, SellerPo.class);
	}
	
	public List<Map<String ,Object>> findsell(){
		String sql1="select distinct(sid),sname,sshopname from meituan_seller_info";
		String sql2="select g.sid,s.sname,s.sshopname,sum(o.ocount) sum from meituan_uorder o inner join meituan_goods_info g on o.gid = g.gid inner join meituan_seller_info s on g.sid=s.sid  and g.sid= ? group by g.sid,s.sname,s.sshopname";
		List<Map<String ,Object>> list1 = db.select(sql1, null);
		List<Map<String ,Object>> lists = new ArrayList<Map<String,Object>>();//用于存放最终结果
		List<Object> params=null;
		List<Map<String ,Object>> list2 = null;
		if(null!=list1 && list1.size()>0){
			for(int i=0;i<list1.size();i++){
				System.out.println("sid::"+list1.get(i).get("SID"));
				params = new ArrayList<Object>();
				params.add(list1.get(i).get("SID"));
				list2 = db.select(sql2, params);
				System.out.println("list2:"+list2);
				if(null!=list2 && list2.size()>0){
					lists.add(list2.get(0));
				}
			}
		}
		return lists;
	}
	
	
	
}
