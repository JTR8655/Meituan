package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import meituan.biz.IIndexGoodsBiz;
import meituan.biz.IUserFunctionBiz;
import meituan.biz.bizImpl.IndexGoodsBizImpl;
import meituan.biz.bizImpl.UserFunctionBizImpl;
import meituan.po.JsonModel;
import meituan.po.UorderPo;
import meituan.po.User;
import meituan.vo.NoEvalVo;

public class UserFunctionServlet extends CommonServlet{

	//获取用户id
	private int getMuid(HttpServletRequest request){
		User user;
		int muid=0;
		if(null!=(User)request.getSession().getAttribute("user")){
			user=(User)request.getSession().getAttribute("user");
			muid = user.getMuid();
		}
		return muid;
	}
	PrintWriter out;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op=request.getParameter("op");
		System.out.println("op:"+op);
		if(op.equals("UserPingjia")){
			uPingjia(request,response);
		}else if("deleteCollection".equals(op)){
			deleteCollection(request, response);
		}else if("goods_info".equals(op)){
			getGoodsInfo(request, response);
		}else if("showNoEvaluate".equals(op)){
			showNoEvalOrder(request, response);
		}else if("showEvaluated".equals(op)){
			showEvaluated(request, response);
		}else if("showAllOrder".equals(op)){
			showAllOrder(request, response);
		}
	}

	/**
	 * 显示所有订单
	 */
	private void showAllOrder(HttpServletRequest request, HttpServletResponse response) {
		int muid = getMuid(request);
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		JsonModel jm=new JsonModel();
		List<Map<String ,Object>> list = biz.showAllOrder(muid);
		System.out.println("所有订单:"+list);
		System.out.println("订单数"+list.size());
		if(null!=list && list.size()>0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}
	
	/**
	 * 显示未评价订单
	 * @param response 
	 * @param request 
	 */
	public void showNoEvalOrder(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		int muid = getMuid(request);
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		JsonModel jm=new JsonModel();
		List<NoEvalVo> list=biz.showNoEvaList(muid);
		System.out.println("未评价："+list);
		if(null!=list && list.size()>0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}

	/**
	 * 评价订单，龙振宇
	 * @param request
	 * @param response
	 */
	public void uPingjia(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		int muid = getMuid(request);
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		JsonModel jm=new JsonModel();
	//	int eid=Integer.parseInt(request.getParameter("eid"));
		Random rd=new Random();
		int eid=rd.nextInt(1000);
		int hid =Integer.parseInt(request.getParameter("hid"));
		int oid=Integer.parseInt(request.getParameter("oid"));
		String econtent=request.getParameter("pingjiaDetail")+"";
		String egrade_1=request.getParameter("count1");
//		String egrade_2=request.getParameter("count2");
//		String egrade_3=request.getParameter("count3");
//		String egrade_4=request.getParameter("count4");
//		String img="";
		System.out.println("count1:"+egrade_1);
		List<Object>params=new ArrayList<Object>();
		params.add(eid);
		params.add(muid);
		params.add(oid);
		params.add(Integer.parseInt(egrade_1));
//		params.add(egrade_2);
//		params.add(egrade_3);
//		params.add(egrade_4);
		params.add(econtent);
//		params.add(img);
		params.add(hid);
		System.out.println("params:"+params);
		int result=biz.uPingjia(params);
		
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
		
	}
	
	
	private void deleteCollection(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		String gid = request.getParameter("gid");
		int result = biz.deleteCollection(gid);
		if(result>0){
			out = response.getWriter();
			out.print(0);
		}else{
			out = response.getWriter();
			out.print(1);
		}
		
	}

	private void getGoodsInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		String status=request.getParameter("status");
		List<Map<String, Object>> list = null;
		if(status.equals("0")){
			list = biz.showCollection_1();
			System.out.println(list);
		}else if(status.equals("1")){
			list = biz.showCollection_2();
		}else if(status.equals("2")){
			list = biz.showCollection_3();
		}
		JSON json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(json.toString());
	}	

	private void showEvaluated(HttpServletRequest request,HttpServletResponse response) throws IOException {
		IUserFunctionBiz biz=new UserFunctionBizImpl();
		JsonModel jm=new JsonModel();
		int muid = getMuid(request);
		System.out.println(168);
		List<Map<String,Object>> list = biz.showEvaluated(muid);
		System.out.println("list!@："+list);
		if(null!=list && list.size()>0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
		}
		super.outData(response, jm);
	}
}
