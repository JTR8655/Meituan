package com.jk.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jk.bean.JsonModel;

/**
 * servlet适配器
 */
public abstract class CommonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8492463623794179081L;
	
	protected int rows=10;
	protected int page=1;
	protected String sort;
	protected String order="asc";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if( req.getParameter("rows")!=null ){
			rows=Integer.parseInt( req.getParameter("rows") );
		}
		
		if( req.getParameter("page")!=null ){
			page=Integer.parseInt( req.getParameter("page") );
		}
		
		if( req.getParameter("sort")!=null ){
			sort=req.getParameter("sort");
		}
		
		if( req.getParameter("order")!=null ){
			order=req.getParameter("order");
		}
		
		super.service(req, resp);		
	}
	
	public void outData(HttpServletResponse response,JsonModel jm){
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
			
			Gson gson=new Gson();
			String returnvalue=gson.toJson(jm);
			
			out.println(returnvalue);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			out.close();
		}
	}
	
	public void outData(HttpServletResponse response,Object jm){			
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
			Gson gson=new Gson();								
			String returnvalue=gson.toJson( jm );						
			out.println(returnvalue);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			out.close();
		}
	}

}
