package meituan.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meituan.biz.IShowGoodsInfoBiz;
import meituan.biz.bizImpl.ShowGoodsInfoBizImpl;
import meituan.po.GoodsIntroPo;
import meituan.po.JsonModel;

@SuppressWarnings("serial")
public class ShowGoodsInfoServlet extends CommonServlet {

	JsonModel jm = new JsonModel();
	IShowGoodsInfoBiz biz = new ShowGoodsInfoBizImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals("showGoodsInfo")){
			showGoodsInfo(request, response);
		}else if(op.equals("otherFoods")){
			otherFoods(request, response);
		}else if(op.equals("mustKnow")){
			must_know(request, response);
		}else if(op.equals("showEvaluatePoint")){
			showEvaluatePoint(request, response);
		}else if(op.equals("showEvaluateContent")){
			showEvaluateContent(request, response);
		}
	}

//显示商家其他商品
	private void otherFoods(HttpServletRequest request, HttpServletResponse response) {
		String sid = request.getParameter("sid");
		List<Map<String, Object>> list = biz.otherFoods(sid);
		System.out.println("list::"+list);
		if(list!=null && list.size()>0){
			jm.setObj(list);
			super.outData(response, jm);
		}
	}

	//显示评分
	private void showEvaluatePoint(HttpServletRequest request, HttpServletResponse response) {
		int gid = Integer.parseInt(request.getParameter("gid"));
		List<Map<String, Object>> list = biz.showEvaluatePoint(gid);
		System.out.println("所有list:"+list);
		if(list.get(0).get("AMOUNT").equals("0")){
			list.get(0).remove("GRADE");
			list.get(0).put("GRADE", 0);
		}
		if(list!=null && list.size()>0){
			jm.setObj(list);
			super.outData(response, jm);
		}
	}

	//显示用户须知
	private void must_know(HttpServletRequest request, HttpServletResponse response) {
		List<GoodsIntroPo> list = biz.must_know();
		if(list!=null && list.size()>0){
			jm.setObj(list);
			super.outData(response, jm);
		}
	}
	
	//显示商品详情
	private void showGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		List<Map<String, Object>> list = biz.showGoods(gid);
		System.out.println("list:"+list);
		if(list!=null && list.size()>0){
			jm.setObj(list);
			super.outData(response, jm);
		}	
	}
	
	//显示评价内容
	private void showEvaluateContent(HttpServletRequest request, HttpServletResponse response) {
		int gid = Integer.parseInt(request.getParameter("gid"));
		List<Map<String, Object>> list = biz.showEvaluateContent(gid);
		System.out.println("评论内容:"+list);
		if(list!=null && list.size()>0){
			jm.setObj(list);
			super.outData(response, jm);
		}
	}
}
