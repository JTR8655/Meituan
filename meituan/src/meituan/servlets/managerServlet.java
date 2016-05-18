package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import meituan.biz.ImanagerBiz;
import meituan.biz.bizImpl.ManagerOperateImpl;
import meituan.po.JsonModel;
import meituan.po.ManagerPo;
import meituan.po.SellerPo;
import meituan.po.User;
/**
 * 
 * @author hy
 *
 */
public class managerServlet extends CommonServlet{
	private HttpSession session;
	private PrintWriter out;
	private JSON json;
	private JSONObject jb;
	private ImanagerBiz biz=new ManagerOperateImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		session = request.getSession();
		out = response.getWriter();
		
		if(op!=null){
			if("login".equals(op)){//登录
				login(request,response);
			}else if("getAdminInfo".equals(op)){//分页查询管理员信息
				getAdminInfo(request,response);
			}else if("addAdminInfo".equals(op)){//添加管理员
				addAdminInfo(request,response);
			}else if("updateAdminInfo".equals(op)){//修改管理员
				updateAdminInfo(request,response);
			}else if("delAdminInfo".equals(op)){//删除管理员
				delAdminInfo(request,response);
			}else if("getPageShopInfo".equals(op)){//查看未激活商家信息
				getPageShopInfo(request,response);
			}else if("activeShop".equals(op)){//激活商家
				activeShop(request,response);
			}else if("getUserinfo".equals(op)){//查看用户信息
				getUserinfo(request,response);
			}else if("delUserinfo".equals(op)){
				delUserinfo(request,response);
			}else if("getShopInfo".equals(op)){//查看已激活商家
				getShopInfo(request,response);
			}else if("findxiaoliang".equals(op)){//根据sid查看商家销量
				findxiaoliang(request,response);
			}
		}
	}
private void findxiaoliang(HttpServletRequest request,
			HttpServletResponse response) {
		//1.写一个方法，查出所有的 商家名，统计每个商家的销量
	List<Map<String ,Object>> lists = biz.findsell();
	for(int i=0;i<lists.size();i++){
		if(null == lists.get(i).get("SUM")){
			lists.get(i).remove("SUM");
			lists.get(i).put("SUM", 0);
		}
	}
	
	JsonModel jm=new JsonModel();
	if(null!=lists && lists.size()>0){
		jm.setCode(1);
		jm.setObj(lists);
	}else{
		jm.setCode(0);
	}
	super.outData(response, jm);
}

/*
	private void findBySid(HttpServletRequest request,
			HttpServletResponse response) {
		  List<EchartData> echartDataList = new ArrayList<EchartData>();
          EchartData echart = new EchartData();
          echart.setLegend("增长量");
          echart.setXdata(new ArrayList<String>(Arrays.asList()));//里面值填充数组 datas = new String[]{"北京","天津"....}
          //echart.setData(new ArrayList<Integer>(Arrays.asList(2,7,8....)));//里面值填充数组 datas = new Integer[]{2,7,8.....}
          echartDataList.add(echart);
          json= JSONArray.fromObject(echartDataList);//将值一json格式返回
		
	}
*/
	private void getShopInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		System.out.println(page+" "+rows);
		List<SellerPo> sellor=biz.findAAlive(Integer.parseInt(page), Integer.parseInt(rows));
		System.out.println("sellor:"+sellor);
		json=JSONArray.fromObject(sellor);
		jb=new JSONObject();
		jb.put("total", biz.all());
		jb.put("rows", json);
		out.print(jb.toString());
		out.flush();
		out.close();
		
	}

	//删除用户
	private void delUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		String muid=request.getParameter("muid");
		if(biz.delUserinfo(muid)>0){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}

	//
	private void getUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		//System.out.println(page+" "+rows);
		List<User> user=biz.findUser(Integer.parseInt(page), Integer.parseInt(rows));
		json=JSONArray.fromObject(user);
		jb=new JSONObject();
		jb.put("total", biz.allUser());
		jb.put("rows", json);
		out.print(jb.toString());
		out.flush();
		out.close();
		
	}

	//激活商家
	private void activeShop(HttpServletRequest request,
			HttpServletResponse response) {
		int sid=Integer.parseInt(request.getParameter("sid"));
		int status=Integer.parseInt(request.getParameter("status"));
		SellerPo po=new SellerPo();
		po.setSid(sid);
		po.setStatus(status);
		if(biz.activeShop(sid,status)>0){ //添加成功
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
		
		
	}

	//查看商家信息
	private void getPageShopInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		System.out.println(page+" "+rows);
		List<SellerPo> sellor=biz.findAlive(Integer.parseInt(page), Integer.parseInt(rows));
		json=JSONArray.fromObject(sellor);
		jb=new JSONObject();
		jb.put("total", biz.all());
		jb.put("rows", json);
		out.print(jb.toString());
		out.flush();
		out.close();
		
	}

	public  void getAdminInfo(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		//System.out.println(page+" "+rows);
		List<ManagerPo> manager=biz.find(Integer.parseInt(page), Integer.parseInt(rows));
		json=JSONArray.fromObject(manager);
		jb=new JSONObject();
		jb.put("total", biz.total());
		jb.put("rows", json);
		out.print(jb.toString());
		out.flush();
		out.close();
	}

	public  void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session=request.getSession();
		String mname=request.getParameter("name");
		String  pwd=request.getParameter("pwd");
		//System.out.println("管理员姓名"+mname);
		//System.out.println("管理员密码"+pwd);
		ManagerPo mpo=new ManagerPo();
		mpo.setMname(mname);
		mpo.setMpwd(pwd);
		ManagerPo po=biz.login(mpo);
		if(po!=null){
			//先存入session
			request.getSession().setAttribute("mname", mname);
			request.getSession().setAttribute("pwd", pwd);
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();		
	}
	
	//添加管理员
	private void addAdminInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		session=request.getSession();
		out=response.getWriter();
		String mname=request.getParameter("mname");
		String  pwd=request.getParameter("mpwd");
		ManagerPo mpo=new ManagerPo();
		mpo.setMname(mname);
		mpo.setMpwd(pwd);
		if(biz.addAdminInfo(mpo)==true){//添加成功
			out.print(1);
		}else{
			out.print(0);
		}
	}
	//修改管理员信息
	private void updateAdminInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String mname=request.getParameter("mname");
		String mpwd=request.getParameter("mpwd");
		String mid=request.getParameter("mid");
		if(biz.updateAdminInfo(new ManagerPo(Integer.parseInt(mid),mname,mpwd))>0){ //添加成功
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}
	//删除管理员
	private void delAdminInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String mid=request.getParameter("mid");
		if(biz.delAdminInfo(mid)>0){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}


}
