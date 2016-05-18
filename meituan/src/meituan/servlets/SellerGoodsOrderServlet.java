package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meituan.biz.bizImpl.SellerGoodsOrderBizImpl;
import meituan.biz.bizImpl.SellerOperateBizImpl;
import meituan.dao.DBHelper;
import meituan.po.GoodsInfoPo;
import meituan.po.GoodsIntroPo;
import meituan.po.GoodsOrderPo;
import meituan.po.SellerPo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SellerGoodsOrderServlet extends HttpServlet {
	public PrintWriter out;
	private DBHelper db = new DBHelper();
	private JSONArray json;
	private JSONObject jb;

	
	private SellerGoodsOrderBizImpl biz = new SellerGoodsOrderBizImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("findByGoodOrderspage".equals(op)) {// 查看订单信息
			findByGoodOrderspage(request, response);
		} else if ("updateOrder".equals(op)) {// 修改订单状态
			updateOrder(request, response);
		}
	} 

	/**
	 * 查看订单信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void findByGoodOrderspage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// System.out.println("-------------");
	//	System.out.println( "asdasd::::::"+request.getSession().getAttribute("sid"));
		int sid = (Integer) request.getSession().getAttribute("sid");
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
	
		List<GoodsOrderPo> goods1 = biz.getGoodsCount1(sid);
		List<GoodsOrderPo> list = null;
		//判断是否有商品存在
		if ( goods1.size()<=0 || goods1==null ) {
			//如果没有 则。。。。
			list = biz.findAllGoodsOrderBypage(sid,0,0);  //  (sid,0,null)
		} else {
			//如果有
			list = biz.findAllGoodsOrderBypage(sid,Integer.parseInt(pageNo),Integer.parseInt(pageSize));
		}
		
		json = JSONArray.fromObject(list);
		jb = new JSONObject();
		jb.put("total",  biz.getCount(sid));
		jb.put("rows", json);
		out = response.getWriter();
		out.print(jb.toString());
	}

	/**
	 * 修改订单状态
	 */
	private void updateOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ostatus = request.getParameter("ostatus");

		// System.out.println(saccounts+"----"+sphone+"---"+spwd);
		GoodsOrderPo order = new GoodsOrderPo();
		order.setOstatus(ostatus);

		boolean flag = biz.updateOrder(order);
		out = response.getWriter();
		if (flag) {// 成功
			out.print(1);
		}

	}
}
