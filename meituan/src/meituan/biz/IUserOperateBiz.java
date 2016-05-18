package meituan.biz;

import java.util.List;
import java.util.Map;

import meituan.po.User;

public interface IUserOperateBiz {
	//用户注册
	public int register(User user);
	
	public Boolean addUser(User user);
	//用户登录 用户名登录
	public User login1(User user);
//	//邮箱登录
//	public User login2(User user);
	//用户注册时检验邮箱是否被注册过
	public User checkEmail(User user);
	//用户注册时检验账号是否被注册过
	public User checkUserAccount(User user);
	//邮箱验证
	public int updateStatus(Integer muid, Integer ustatus);

	public boolean findEmail(User user);
	//忘记密码
	public boolean fogetPwd(String pwd, String email);

	public boolean checkFEmail(User user);
	
	public List<Map<String,Object>> search(String str);

}
