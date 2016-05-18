package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import meituan.biz.IUserOperateBiz;
import meituan.biz.bizImpl.UserOperateBizImpl;
import meituan.po.JsonModel;
import meituan.po.User;
import meituan.utils.SendEmailUtil;

/**hy
 * 用于对用户个人的操作，如查看、修改个人信息
 */
public class UserOperateServlet extends CommonServlet{
		private HttpSession session;
		private PrintWriter out;
		private IUserOperateBiz userbiz=new UserOperateBizImpl();
		private JSONArray json;
		private JSONObject jb;
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		if(op!=null){
			if("addUser".equals(op)){
				addUser(request,response);
			}else if("login1".equals(op)){
				login1(request,response);
			}else if("checkEmail".equals(op)){
				checkEmail(request,response);
			}else if("checkUserAccount".equals(op)){
				checkUserAccount(request,response);
			}else if("change".equals(op)){
				Change(request,response);
			}else if("checkforgetEmail".equals(op)){//查询
				checkforgetEmail(request,response);
			}else if("updatePwd".equals(op)){//修改
				updatePwd(request,response);
			}else if("forgetEmail".equals(op)){//修改
				forgetEmail(request,response);
			}else if("showUseInfo".equals(op)){
				showUserInfo(request,response);
			}else if("logOut".equals(op)){
				logOut(request,response);
			}else if("Search".equals(op)){
				Search(request,response);
			}
		}
	}
	
	//搜索
	private void Search(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jm = new JsonModel(); 
		String str = request.getParameter("str");
		IUserOperateBiz biz = new UserOperateBizImpl();
		List<Map<String,Object>> list = biz.search(str);
		if(null != list && list.size()>0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		System.out.println("logOut");
		JsonModel jm=new JsonModel();
		System.out.println("user:"+(User)session.getAttribute("user"));
		if(null!=(User)session.getAttribute("user")){
			session.removeAttribute("user");	
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}

	/**
	 * 显示用户信息
	 * @param request
	 * @param response
	 */
	private void showUserInfo(HttpServletRequest request, HttpServletResponse response) {
		User user=(User)request.getSession().getAttribute("user");
		JsonModel jm=new JsonModel();
		if(null!=user){
			jm.setObj(user);
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
		
	}

	/**
	 * 找回密码，发邮件到邮箱
	 * @param request
	 * @param response
	 */
	private void forgetEmail(HttpServletRequest request, HttpServletResponse response) {
		SendEmailUtil sendEmail=new SendEmailUtil(true);
		JsonModel jm=new JsonModel();
		String email=(String)request.getParameter("email");
		String content="<p>Hi~"+email+"</p><p><a href='http://localhost:8080/meituan/updatepwd.html?email="+email+"'>您在美.团网申请了【找回登录密码】的邮箱验证，请点击本链接，然后根据页面提示完成验证</a></p>";
		sendEmail.send(content, email, null);
		if(sendEmail.flag){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}

	private void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		String email=(String)request.getSession().getAttribute("uemail");
//		String email=request.getParameter("email");
		System.out.println("修改密码"+email);
		String pwd=request.getParameter("pwd");
		String repwd=request.getParameter("repwd");
		if(pwd.equals(repwd)){
			if(userbiz.fogetPwd(pwd, email)){
				jm.setCode(1);
				//jm.setObj(user);
			}else{
				jm.setCode(0);
			}
		}else{
			jm.setCode(2);
		}
		super.outData(response, jm);
	}

	/**
	 * 检查邮箱
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void checkforgetEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		String email=request.getParameter("email");
		System.out.println(email);
		String code=(String)request.getSession().getAttribute("code");
		String recode=request.getParameter("recode");
		System.out.println(code+"\t"+recode);
		User user=new User();
		user.setUemail(email);
		if(code.equals(recode)){
			if(userbiz.checkFEmail(user)){
				request.getSession().setAttribute("uemail", email);//存到session中
				jm.setCode(1);
			}else{
				jm.setCode(0);
			}
		}else{
			jm.setCode(2);
		}
//		response.sendRedirect("updatepwd.html");
		super.outData(response, jm);
	}
	
	private void fogetPwd(HttpServletRequest request,
			HttpServletResponse response) {
		String email=request.getParameter("uemail");
		System.out.println(email);
		String code=(String)request.getSession().getAttribute("code");
		String recode=request.getParameter("recode");
	}

	private void Change(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer muid=Integer.valueOf(request.getParameter("muid"));
		userbiz.updateStatus(muid, 1);
		response.sendRedirect("reg_ok.html");//重定向
	}
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void addUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("添加用户");
		JsonModel jm=new JsonModel();
		session=request.getSession();
		out=response.getWriter();
		String email=request.getParameter("email");
		String uname=request.getParameter("username");
		String upwd=request.getParameter("pwd");
		String uaddr=request.getParameter("uaddr");
		String code=(String)request.getSession().getAttribute("code");
		System.out.println(code);
		String recode=request.getParameter("recode");
		System.out.println(recode);
		User user=new User();
		user.setUemail(email);
		user.setUaccounts(uname);
		user.setUpwd(upwd);
		user.setUaddr(uaddr);
		if(code.equals(recode)){
			if(userbiz.addUser(user)==true){//添加成功
				jm.setCode(1);
				jm.setObj(user);
			}else{
				jm.setCode(0);
			}
		}else{
			jm.setCode(2);
		}
		System.out.println(jm.getCode());
		super.outData(response, jm);
	}
	
	
	//用户登录 用户名登录
	public  void login1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session=request.getSession();
		out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User();
		if(email.indexOf("@") > 0) {//判断是否用邮箱登录
			user.setUemail(email);
		} else {
			user.setUaccounts(email);//否则用户账号
		}
		user.setUpwd(password);
		User userpo=userbiz.login1(user);
		if(userpo!=null){
			session.setAttribute("user", userpo);
			out.print(1);
			
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}
	//检查邮箱是否被注册
	public void checkEmail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {		
		session=request.getSession();
		String email=request.getParameter("email");
		User user=new User();
		user.setUemail(email);
		User userpo=userbiz.checkEmail(user);
		out=response.getWriter();
		if(userpo!=null){
			out.print(1);	
		}else{
			out.print(0);
		}
		
	}
	//检查用户账号是否被注册过
	public  void checkUserAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		session=request.getSession();
		String uaccounts=request.getParameter("username");
		System.out.println(uaccounts);
		User user=new User();
		user.setUaccounts(uaccounts);
		User userpo=userbiz.checkUserAccount(user);
		out=response.getWriter();
		if(userpo!=null){
			out.print(1);	
		}else{
			out.print(0);
		}
		
	}

}
