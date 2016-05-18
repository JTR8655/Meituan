package meituan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meituan.biz.IFairBiz;
import meituan.biz.bizImpl.FairBizImpl;
import meituan.po.JsonModel;
import meituan.po.UorderPo;

@SuppressWarnings("serial")
public class FairServlet extends CommonServlet {

	JsonModel jm = new JsonModel();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op != null){	
			if("submitFair".equals(op)){
				submitFair(request, response);
			}
		}
	}

	private void submitFair(HttpServletRequest request, HttpServletResponse response) {
		int muid = Integer.parseInt(request.getParameter("muid"));
		int count = Integer.parseInt(request.getParameter("tcount"));
		int gid = Integer.parseInt(request.getParameter("gid"));
		int oidentifier = 100001;
		int counts = 10001;
		oidentifier += 1;
		counts += 1;
		String opwd = "MT"+counts;
		UorderPo po = new UorderPo();
		po.setOidentifier(oidentifier);
		po.setMuid(muid);
		po.setGid(gid);
		po.setOcount(count);
		po.setOpwd(opwd);
		IFairBiz biz = new FairBizImpl();
		int i = biz.cart(po);
		if(i > 0){
			jm.setObj(opwd);
			super.outData(response, jm);
		}
		
	}
	
}
