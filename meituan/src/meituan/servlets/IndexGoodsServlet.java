package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meituan.biz.IIndexGoodsBiz;
import meituan.biz.bizImpl.IndexGoodsBizImpl;
import meituan.po.GoodsInfoPo;
import meituan.po.JsonModel;
import meituan.po.User;

@SuppressWarnings("serial")
public class IndexGoodsServlet extends CommonServlet {

	IIndexGoodsBiz biz = new IndexGoodsBizImpl();
	private PrintWriter out;
	JsonModel jm = new JsonModel();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op!=null){
			if("shangpin_info".equals(op)){
				showGoodsDetail(request, response);
			}else if("collection_info".equals(op)){
				collectGoods(request, response);
			}else if("check_coll".equals(op)){
				checkCollection(request, response);
			}else if("showCollection".equals(op)){
				showCollection(request, response);
			}
		}
	}
	
	//首页显示商品
	protected void showGoodsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GoodsInfoPo> list = biz.showDetail();
		if(list!=null && list.size()>0){
			jm.setObj(list);
		}
		super.outData(response, jm);
	}
	
	protected void collectGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		User user = null;
		int muid=0;
		
		if(null!=(User)request.getSession().getAttribute("user")){
			user=(User)request.getSession().getAttribute("user");
			muid = user.getMuid();
		}
		//Object muid = session.getAttribute("user");
		int result = biz.collectGoods(gid,muid);
		out = response.getWriter();
		if(result>0){
			System.out.println("收藏成功！");
			out.print(1);
		}else if(result == -1){
			out.print(-1);
		}else{
			System.out.println("收藏失败！");
			out.print(0);
		}
		out.flush();
		out.close();
	}
	
	protected void checkCollection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		List<Map<String, Object>> list = biz.checkCollection(gid);
		if(list==null){
			jm.setObj(list);
		}else{
			jm.setObj(list);
		}
		super.outData(response, jm);	
	}
	
	protected void showCollection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = biz.showCollection();
		out = response.getWriter();
		if(list!=null){
			out.print(1);
		}
	}
	
}
