package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




import meituan.biz.IAdminBiz;
import meituan.biz.ISellerOperateBiz;
import meituan.biz.bizImpl.SellerOperateBizImpl;
import meituan.dao.DBHelper;
import meituan.po.GoodsInfoPo;
import meituan.po.SellerPo;
import meituan.po.User;

@SuppressWarnings("serial")
public class SellerOperateServlet extends HttpServlet{
	public PrintWriter out;
	private DBHelper db=new DBHelper();
	 private JSONArray json;
	 private JSONObject jb;
	 public   HttpSession session;
	 List<SellerPo> list;
	 private SellerOperateBizImpl biz=new SellerOperateBizImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String op=request.getParameter("op");
		
		 if(op.equals("addSellerPo")){
			addSellerPo(request,response);
		}else if(op.equals("sLogin")){
			sLogin(request,response);
		}else if(op.equals("findBypage")){
			findBypage(request,response);  
		}else if("updateAdmin".equals(op)){
			updateAdmin(request,response);
		}
		 
		 
}	
	
	//修改个人信息updateAdmin
	private void updateAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String saccounts=request.getParameter("saccounts");
		String sphone=request.getParameter("sphone");
		String spwd=request.getParameter("spwd");
		
	//	System.out.println(saccounts+"----"+sphone+"---"+spwd);
		SellerPo seller=new SellerPo();
		seller.setSpwd(spwd);
		seller.setSphone(sphone);
		seller.setSaccounts(saccounts);
		boolean flag=biz.updateAdmin(seller);
		out=response.getWriter();
		if(flag){//成功
			out.print(1);
		}
		
	}

	//显示当前登录商家信息
	private void findBypage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String saccounts= (String) session.getAttribute("saccounts");
		
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		List<SellerPo> list=null;
		if(null==pageNo||"".equals(pageNo)||null==pageSize||"".equals(pageSize)){
			list=biz.findBypage(null, null,null);
		}else{
			list=biz.findBypage(Integer.parseInt(pageNo), Integer.parseInt(pageSize),saccounts);
		}
		
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		jb.put("total", (int)biz.getCount1(saccounts));
		jb.put("rows", json);
		out=response.getWriter();
		out.print(jb.toString());
	}

	//商家登录
	public void sLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		session =request.getSession();
		ISellerOperateBiz biz=new SellerOperateBizImpl();
		out=response.getWriter();
		String saccounts=request.getParameter("saccounts");
		String spwd=request.getParameter("spwd");
		
		SellerPo seller=new SellerPo();
		seller.setSaccounts(saccounts);
		seller.setSpwd(spwd);
	    list=biz.sLogin(seller);
		if(null!=list && list.size()>0){
			session.setAttribute("admin", list.get(0));
			session.setAttribute("saccounts", list.get(0).getSaccounts());
			session .setAttribute("sid", list.get(0).getSid());
			out.print(1);
		}else{
			out.print(0);
		}
//		json=JSONArray.fromObject(list.get(0));
//		out.print(json.toString());
	}
	
	//商家注册
	public void addSellerPo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		out=response.getWriter();
		
		String s_spwd=request.getParameter("spwd");
		String s_saddr=request.getParameter("saddr");
		String s_sshopname=request.getParameter("shopname");
		String s_stype=request.getParameter("stype");
		String s_sname=request.getParameter("sname");
		String s_seamil=request.getParameter("semail");
		String s_slicense=request.getParameter("license");
		String s_sphone=request.getParameter("sphone");
		
		SellerPo po1=new SellerPo();
		
		po1.setSpwd(s_spwd);
		po1.setSaddress(s_saddr);
		po1.setSshopname(s_sshopname);
		po1.setStype(s_stype);
		po1.setSname(s_sname);
		po1.setSemail(s_seamil);
		po1.setSlicense(s_slicense);
		po1.setSphone(s_sphone);
		
		
		if(biz.addSellerPo(po1)==true){//添加成功
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}
}
