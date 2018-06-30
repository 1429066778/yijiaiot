package controller;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import Bean.Bean;
public class RightFilter implements Filter {
	int flag=0;
	String x="请先登录！";
	public void init(FilterConfig filterConfig)throws ServletException{
		
	}
/**
 * @author 田培贤
 * 过滤器，防止用户不登录直接操作
 */
	public void doFilter(ServletRequest request, ServletResponse response,
			   FilterChain chain) throws IOException, ServletException {
		       //获得session对象
			  response.setCharacterEncoding("utf-8");
			  HttpServletRequest servletRequest = (HttpServletRequest) request;
			  HttpServletResponse servletResponse = (HttpServletResponse) response;
			  HttpSession session = servletRequest.getSession();
			  String path = servletRequest.getRequestURI();
			  Bean user = (Bean) session.getAttribute("user");
			  if(user!=null&&user.Get_username()!=null)
			  {
				  System.out.println("用户已登录");
				  chain.doFilter(servletRequest, servletResponse);
				  return;
			  }
			  System.out.println(path);
			  x=java.net .URLEncoder.encode(x,"utf-8");
			  if(path.indexOf("/login.jsp") > -1||path.indexOf("/zuce.jsp")>-1) {
				  chain.doFilter(servletRequest, servletResponse);	
			  }else {
				  ((HttpServletResponse) response).sendRedirect("login.jsp?use="+x);
				  return;
			  }
		    }
			public void destroy() {
				
			}
}
