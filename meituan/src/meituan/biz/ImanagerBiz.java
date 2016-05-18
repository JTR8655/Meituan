package meituan.biz;

import java.util.List;
import java.util.Map;

import meituan.po.ManagerPo;
import meituan.po.SellerPo;
import meituan.po.User;

public interface ImanagerBiz {
	
	// 管理员登录
	public ManagerPo login(ManagerPo po);
	
	//查询所有管理员
	public int total();
	
	//分页查询管理员信息
	public List<ManagerPo> find(Integer pageNo,Integer pageSize);
	
	//添加管理员
	public Boolean addAdminInfo(ManagerPo po);
	
	//修改管理员
	public int updateAdminInfo(ManagerPo po);
	
	//删除管理员
	public int delAdminInfo(String mid);
	
	//分页 查询未激活商家
	public List<SellerPo> findAlive(Integer pageNo,Integer pageSize);
	//查询已激活商家
	public List<SellerPo> findAAlive(Integer pageNo,Integer pageSize);
	//查询所有商家
	public int all();
	
	//激活商家
	//public int activeShop(SellerPo spo);

	public int activeShop(int sid, int status);
	
	//查询所有用户
	public int allUser();
	
	//分页查询用户信息
	public List<User> findUser(Integer pageNo,Integer pageSize);
	
	//删除用户
	public int delUserinfo(String muid);
	
	//根据商家sid查询销量
	public int findUorder(String sid);
	
	//根据商家sid查询所欲商家名
	public List<SellerPo>  findName(String sid);
	
	//统计销量
	public List<Map<String ,Object>> findsell();
}
