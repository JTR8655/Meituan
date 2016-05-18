package meituan.biz.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import meituan.biz.IUserOperateBiz;
import meituan.commons.MD5Encryption;
import meituan.dao.DBHelper;
import meituan.po.User;
import meituan.utils.SendEmailUtil;

public class UserOperateBizImpl implements IUserOperateBiz{
	DBHelper db=new DBHelper();
	
	@Override
	public int register(User user) {//邮箱注册
		String sql="insert into meituan_user_info values(seq_meituanuser.nextval,?,?,?,null,null,null,null,null,null,null,null,null,null,null,null)";
		List<Object> params=new ArrayList<Object>();
		params.add("username");
		params.add("pwd");
		params.add("email");
		return db.update(sql, params);
	}
	
	/**
	 * hy
	 */
	@Override
	public Boolean addUser(User user) {
		String sql="insert into meituan_user_info values(seq_meituanuser.nextval,?,?,?,null,default,default,default,null,null,null,null,null,null,?,sysdate)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUaccounts());
		params.add(MD5Encryption.createPassword(user.getUpwd()));
		params.add(user.getUemail());
		params.add(user.getUaddr());
		int i=db.update(sql, params);
		if(i>0){
			//插入数据成功，则发送激活邮件到用户邮箱
			boolean sendFlag=sendCheckEmail(params);
			System.out.println("第一次发邮件："+sendFlag);
			if(sendFlag){
				return true;
			}else{
				int j=0;
				for(j=0;j<2;j++){
					boolean flag=sendCheckEmail(params);
					System.out.println("第"+(j+1)+"次发邮件："+flag);
					if(flag){
						return true;
					}
				}
				if(j==2){
					//邮件发送失败，删除该数据
					String failSql=" delete from meituan_user_info where uaccounts=? "; 
					List<Object> fParam=new ArrayList<Object>();
					fParam.add(user.getUaccounts());
					db.update(failSql, fParam);
					return false;
				}else{
					return true;
				}
			}
		}else{
			return false;
		}
	}
	
	
	public boolean sendCheckEmail(List<Object> params) {
		System.out.println("发邮件");
		SendEmailUtil  email=new SendEmailUtil(true);
		String sql="select * from meituan_user_info where uemail=?"; 
		List<Object> param=new ArrayList<Object>();
		param.add(params.get(2)); 
		List<User> user=db.find(sql, param, User.class);
		if(null!=user && user.size()>0){
			System.out.println("邮箱："+user.get(0).getUemail());
			String content="<p>Hi~"+user.get(0).getUaccounts()+",</p>"
					+"<p><a href='http://localhost:8080/meituan/UserOperate.do?op=change&muid="+user.get(0).getMuid()+"'>感谢您注册,请点击此链接激活您的账号</a></p>";
			email.send(content, user.get(0).getUemail(), null);
			System.out.println(content);
			if(email.flag){
				return true;
			}
		}else{
			return false;
		}
		return false;		
	}
	

	@Override
	public User login1(User user) {
		String sql = "select * from meituan_user_info where upwd=? and ";
		List<Object> params=new ArrayList<Object>();
	//	params.add(MD5Encryption.createPassword(user.getUpwd()));
		params.add(user.getUpwd());
		String uaccounts = user.getUaccounts();
		if(uaccounts  == null ) {
			sql += "uemail = ?";
			params.add(user.getUemail());
		} else {
			sql += "uaccounts = ?"; 
			params.add(user.getUaccounts());
		}
		//String sql="select * from meituan_user_info where (uaccounts=? and upwd=?) or(uemail=? and upwd=?)";
		//"select * from meituan_user_info where uaccounts=? and upwd=?"
		List<User> list= db.find(sql, params, User.class);
		if(list!=null&&list.size()>0){
			System.out.println(list.get(0).getMuid());
			return list.get(0);
		}else{
			return null;
		}
	}

	
	public User checkEmail(User user) {
		String sql = "select * from meituan_user_info where uemail = ?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUemail());
		List<User> list= db.find(sql, params, User.class);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public User checkUserAccount(User user) {
		String sql="select * from meituan_user_info where uaccounts=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUaccounts());
		List<User> list= db.find(sql, params, User.class);
		if(list!=null&&list.size()>0){
			System.out.println(list);
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateStatus(Integer muid, Integer ustatus) {
		String sql="update meituan_user_info set ustatus=? where muid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(ustatus);
		params.add(muid);
		return db.update(sql, params);
	}

	public boolean fogetPwd(User user) {
		String sql="update meituan_user_info set upwd=? where uemail=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUpwd());
		params.add(user.getUemail());
		int i=db.update(sql, params);
		if(i>0){
			//插入数据成功，则发送激活邮件到用户邮箱
			boolean sendFlag=sendFogetPwd(params);
			System.out.println("第一次发邮件："+sendFlag);
			if(sendFlag){
				return true;
			}else{
				int j=0;
				for(j=0;j<2;j++){
					boolean flag=sendFogetPwd(params);
					System.out.println("第"+(j+1)+"次发邮件："+flag);
					if(flag){
						return true;
					}
				}
				if(j==2){
					//邮件发送失败，删除该数据
					String failSql=" delete from meituan_user_info where uaccounts=? "; 
					List<Object> fParam=new ArrayList<Object>();
					fParam.add(user.getUaccounts());
					db.update(failSql, fParam);
					return false;
				}else{
				return true;
				}
			}
		}else{
			return false;
		}
	}

	public boolean sendFogetPwd(List<Object> params) {
		SendEmailUtil  email=new SendEmailUtil(true);
		String sql="select * from meituan_user_info where uemail=?"; 
		List<Object> param=new ArrayList<Object>();
		param.add(params.get(2)); 
		List<User> user=db.find(sql, param, User.class);
		if(null!=user && user.size()>0){
			System.out.println("邮箱："+user.get(0).getUemail());
			String content="<p>Hi~"+user.get(0).getUaccounts()+",</p>"
					+"<p><a href='http://localhost:8080/meituan/UserOperate.do?op=change&muid="+user.get(0).getMuid()+"'>点此链接创建新密码</a></p>";	
			email.send(content, user.get(0).getUemail(), null);
			System.out.println(content);
			if(email.flag){
				return true;
			}
		}else{
			return false;
		}
		return false;		
	}

	/**
	 * newPwd  根据uemail修改pwd
	 */

	@Override
	public boolean fogetPwd(String pwd, String email) {
		String sql="update meituan_user_info set upwd=? where uemail=?";
		List<Object> params=new ArrayList<Object>();
		params.add(MD5Encryption.createPassword(pwd));
		params.add(email);	
		int i=db.update(sql, params);
		System.out.println("修改"+i);
		if(i>0){//修改成功
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public boolean findEmail(User user) {
		String sql = "select * from meituan_user_info where uemail = ?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUemail());
		List<User> list= db.find(sql, params, User.class);
		if(list!=null&&list.size()>0){//查询成功，
			//则发送激活邮件到用户邮箱
			boolean sendFlag=sendFogetPwd(params);
			System.out.println("第一次发邮件："+sendFlag);
			if(sendFlag){
				return true;
			}else{
				int j=0;
				for(j=0;j<2;j++){
					boolean flag=sendFogetPwd(params);
					System.out.println("第"+(j+1)+"次发邮件："+flag);
					if(flag){
						return true;
					}
				}
				if(j==2){
					//邮件发送失败，删除该数据
					String failSql=" delete from meituan_user_info where uemail=? "; 
					List<Object> fParam=new ArrayList<Object>();
					fParam.add(user.getUemail());
					db.update(failSql, fParam);
					return false;
				}else{
					return true;
				}
			}
		}else{
			return false;
		}
	}

	@Override
	public boolean checkFEmail(User user) {
		String sql="select * from meituan_user_info where uemail=?";
		List<Object>param=new ArrayList<Object>();
		param.add(user.getUemail());
		List<User> list=db.find(sql, param, User.class);
		if(null!=list && list.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String,Object>> search(String str) {
		String sql = "select * from meituan_goods_info where gtitle1 like ? or text like ?";
		List<Object>params = new ArrayList<Object>();
		params.add(str);
		params.add(str);
		return db.select(sql, params);
	}

}
