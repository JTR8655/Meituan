package meituan.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserLogin implements Filter {
	private String errorPage="index.html";
	private String uerrorPage="login.html";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		//检查用户是否登录
		HttpSession session=request.getSession();
		if(null==session.getAttribute("admin")){//说明没有登录
			PrintWriter out=response.getWriter();
			//获取基路径，即webroot下
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>alert('请先登录。');location.href='"+basePath+errorPage+"'</script>");
			out.flush();
			out.close();
		}else if(null==session.getAttribute("user")){
			PrintWriter out=response.getWriter();
			//获取基路径，即webroot下
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>alert('请先登录。');location.href='"+basePath+uerrorPage+"'</script>");
			out.flush();
			out.close();
			
		}else{//说明已经登录，使用下一个过滤器
			arg2.doFilter(request, response);
			
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String temp=arg0.getInitParameter("errorPage");
		if(null!=temp){
			errorPage=temp;
		}
	}

}
