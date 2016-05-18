package meituan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import meituan.biz.bizImpl.SellerOperateBizImpl;
import meituan.commons.FileUpload;
import meituan.dao.DBHelper;
import meituan.po.GoodsInfoPo;
import meituan.po.GoodsIntroPo;
import meituan.po.SellerPo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SellerFunctionServlet extends HttpServlet{
	public PrintWriter out;
	private DBHelper db=new DBHelper();
	 private JSONArray json;
	 private JSONObject jb;
	
	 List<GoodsInfoPo> list;
	 List<GoodsIntroPo> list1;

	 
	 
	 private SellerOperateBizImpl biz=new SellerOperateBizImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String op=request.getParameter("op");
		 if("findBySellerpage".equals(op)){//查看商品信息
			 findBySellerpage(request,response);
		 }else if("addGoodsInfo".equals(op)){ //添加商品信息
				addGoodsInfo(request,response);
		 }else if("updateGoods".equals(op)){//修改商品信息
			 updateGoods(request,response);
		 }else if("findByGoodspage".equals(op)){//
			 findByGoodspage(request,response);
		 }else if("addGoodsIntro".equals(op)){//添加商品附加信息
			 addGoodsIntro(request,response);
		 }else if("updateGoodsIntro".equals(op)){//修改商品附加信息
			 updateGoodsIntro(request,response);
		 }
	
	}
	
	//查询商品信息
		private void findBySellerpage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//	System.out.println("-------------");
			
			String pageNo=request.getParameter("page");
			String pageSize=request.getParameter("rows");  
			List<GoodsInfoPo> goods=biz.getGoodsCount();
			if(null==goods||"".equals(goods) || null==pageSize||"".equals(pageSize)){
				list=biz.findAllBypage(null, null);
			}else{
				list=biz.findAllBypage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			}
		
			json=JSONArray.fromObject(list);
			jb=new JSONObject();
			jb.put("total", (int)biz.getCount());
			jb.put("rows", json);
			out=response.getWriter();
			out.print(jb.toString());
			
			
		}

		
		//修改信息
		private void updateGoods(HttpServletRequest request,HttpServletResponse response) throws IOException {
			int gid=Integer.parseInt(request.getParameter("gid"));
			String gdate=request.getParameter("gadte");
			String privilege=request.getParameter("privilege");
			String gtitle1=request.getParameter("gtitle1");
			String gtitle2=request.getParameter("gtitle2");
			float gprice1=Float.parseFloat(request.getParameter("gprice1"));
			float gprice2=Float.parseFloat(request.getParameter("gprice2"));
			int gsoldcount=Integer.parseInt(request.getParameter("gsoldcount"));
			String img=request.getParameter("img");
			String text=request.getParameter("text");
			int temp1=Integer.parseInt(request.getParameter("temp1"));
			
			//System.out.println(gid+"----"+gdate+"---"+gdate+"---"+privilege+"---"+gtitle1+"---"+gtitle2+"---"+gprice1+"---"+gprice1+"---"+gsoldcount+"---"+img+"---"+text+"---"+temp1);
			GoodsInfoPo goods=new GoodsInfoPo();
			goods.setGid(gid);
			goods.setGdate(gdate);
			goods.setPrivilege(privilege);
			goods.setGtitle1(gtitle1);
			goods.setGtitle2(gtitle2);
			goods.setGprice1(gprice1);
			goods.setGprice2(gprice2);
			goods.setGsoldcount(gsoldcount);
			goods.setImg(img);
			goods.setText(text);
			goods.setTemp1(temp1);
			
			boolean flag=biz.updateGoods(goods);
			out=response.getWriter();
			if(flag){//成功
				out.print(1);
			}
		}
		//添加商品信息
		public void addGoodsInfo(HttpServletRequest request,HttpServletResponse response){
			
			 HttpSession session=request.getSession();
			String saccounts= (String) session.getAttribute("saccounts");
			String sql="select sid from meituan_seller_info where saccounts='"+saccounts+"'";
			DBHelper db=new DBHelper();
			List<GoodsInfoPo> sidlist=db.find(sql, null, GoodsInfoPo.class);
			int sid= (Integer) sidlist.get(0).getSid() ; 
		//	System.out.println("!!!!"+sid);
			
			FileUpload upload=new FileUpload();
			PageContext context=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 1024, true);
				//System.out.println(context);
			try {
				Map<String,String> map=upload.upload(context);
		//	System.out.println(map);
				GoodsInfoPo po=new GoodsInfoPo();
				System.out.println("11111111111"+ map.get("gid"));
				po.setGid(Integer.parseInt(map.get("gid")));
				po.setGdate(map.get("date"));
				po.setPrivilege(map.get("zhekou"));
				po.setSid(sid);
				po.setGtitle1(map.get("title1"));
				po.setGtitle2(map.get("title2"));
				po.setGprice1(Integer.parseInt(map.get("price1")));
				po.setGprice2(Integer.parseInt(map.get("price2")));
			//	po.setGsoldcount(Integer.parseInt(map.get("count")));
				po.setImg(map.get("image"));
				po.setText(map.get("content"));
				//po.setTemp1(Integer.parseInt(map.get("temp1")));
				
			//	System.out.println("po:"+po);
				
				
				boolean flag=biz.add(po);
				out=response.getWriter();
				if(flag){
					out.print(1);
					out.flush();
					out.close();
					
				}
				
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//
		
		//查询商品附加信息
		private void findByGoodspage(HttpServletRequest request,HttpServletResponse response) throws IOException {
				
				String pageNo=request.getParameter("page");
				String pageSize=request.getParameter("rows");  
				List<GoodsIntroPo> goods1=biz.getGoodsCount1();
				if(null==goods1||"".equals(goods1) || null==pageSize||"".equals(pageSize)){
					list1=biz.findAllGoodsIntroBypage(null, null);
				}else{
					list1=biz.findAllGoodsIntroBypage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
				}
				System.out.println("list1:"+list1);
				json=JSONArray.fromObject(list1);
				jb=new JSONObject();
				jb.put("total", (int)biz.getCount());
				jb.put("rows", json);
				System.out.println(jb.toString());
				out=response.getWriter();
				out.print(jb.toString());
			}
		
		//添加商品附加信息
		public void addGoodsIntro(HttpServletRequest request,HttpServletResponse response){HttpSession session=request.getSession();
			String saccounts= (String) session.getAttribute("saccounts");
			System.out.println("saccounts::"+saccounts);
			String sql="select sid from meituan_seller_info where saccounts=?";
			List<Object> param =new ArrayList<Object>();
			param.add(saccounts);
			DBHelper db=new DBHelper();
			List<GoodsIntroPo> sidlist=db.find(sql, param, GoodsIntroPo.class);
			System.out.println("sid集合:"+sidlist);
			int sid= (Integer) sidlist.get(0).getSid() ; 
			FileUpload upload=new FileUpload();
			PageContext context=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 1024, true);
			try {
				Map<String,String> map=upload.upload(context);
				GoodsIntroPo po=new GoodsIntroPo();
				po.setGid(Integer.parseInt(map.get("gid")));
				po.setSid(sid);
				po.setB_retime(map.get("retime"));
				po.setB_usetime(map.get("usetime"));
				po.setB_ordertip(map.get("ordertip"));
				po.setB_parlor(map.get("parlor"));
				po.setB_pack(map.get("pack"));
				po.setB_serve(map.get("serve"));
				po.setB_limittip(map.get("limittip"));
				po.setB_prompt(map.get("prompt"));
				po.setD_taocan(map.get("taocan"));
				po.setD_price1(Float.parseFloat(map.get("price1")));
				po.setD_count(Integer.parseInt(map.get("count")));
			
				boolean flag=biz.add(po);
				out=response.getWriter();
				if(flag){
					out.print(1);
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//修改商品附加信息
		private void updateGoodsIntro(HttpServletRequest request,HttpServletResponse response) throws IOException {
			int gid=Integer.parseInt(request.getParameter("gid"));
			String b_retime=request.getParameter("b_retime");
			String b_usetime=request.getParameter("b_usetime");
			String b_ordertip=request.getParameter("b_ordertip");
			String b_parlor=request.getParameter("b_parlor");
			String b_pack=request.getParameter("b_pack");
			String b_serve=request.getParameter("b_serve");
			String b_limittip=request.getParameter("b_limittip");
			String b_prompt=request.getParameter("b_prompt");
			String d_taocan=request.getParameter("d_taocan");
			float d_price1=Float.parseFloat(request.getParameter("d_price1"));
			int d_count=Integer.parseInt(request.getParameter("d_count"));
			
			GoodsIntroPo goods=new GoodsIntroPo();
			goods.setGid(gid);
			goods.setB_retime(b_retime);
			goods.setB_usetime(b_usetime);
			goods.setB_ordertip(b_ordertip);
			goods.setB_parlor(b_parlor);
			goods.setB_pack(b_pack);
			goods.setB_serve(b_serve);
			goods.setB_limittip(b_limittip);
			goods.setB_prompt(b_prompt);
			goods.setD_taocan(d_taocan);
			goods.setD_price1(d_price1);
			goods.setD_count(d_count);
			
			boolean flag=biz.updateGoodsIntro(goods);
			
			out=response.getWriter();
			if(flag){//成功
				out.print(1);
			}
		}		
}