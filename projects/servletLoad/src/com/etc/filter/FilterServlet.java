package com.etc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

public class FilterServlet implements Filter {  
	
	/*
	1.过滤器的概念(实现了Filter接口的java类)
		Java中的Filter 并不是一个标准的Servlet ，它不能处理用户请求，也不能对客户端生成响应。 
		主要用于对HttpServletRequest 进行预处理，也可以对HttpServletResponse 进行后处理，是个典型的处理链。
		优点：过滤链的好处是，执行过程中任何时候都可以打断，只要不执行chain.doFilter()就不会再执行后面的过滤器和请求的内容。而在实际使用时，就要特别注意过滤链的执行顺序问题
	2.过滤器的作用描述
		在HttpServletRequest 到达Servlet 之前，拦截客户的HttpServletRequest 。 
		根据需要检查HttpServletRequest ，也可以修改HttpServletRequest 头和数据。 
		在HttpServletResponse 到达客户端之前，拦截HttpServletResponse 。 
		根据需要检查HttpServletResponse ，可以修改HttpServletResponse 头和数据。
	*/
	
	// 如果继承了HttpServlet，就不用重写destroy()方法，因为和servlet的销毁是一样的
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	// 页面拦截过滤器
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		// 获取session
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		// 看看请求的资源是什么
		String uri = request.getRequestURI();
		
		if (uri.startsWith("/servletLoad/ResponseServlet")) {
			// 登录页面，直接放行
			chain.doFilter(request, response);
		} else {
			// 检查用户是否登录
			User user = (User) session.getAttribute("loginuser");
			if (user != null) {
				// 用户已登录,放行
				chain.doFilter(request, response);
			} else {
				// 如果没有登录
				request.setAttribute("err", "请好好登陆，可以吗？");
				request.getRequestDispatcher("/ResponseServlet").forward(request,response);
			}
		}
	}
	
	// 编码过滤器
	/*@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		// 传递控制到下一个过滤器
		chain.doFilter(request, response);		
	}*/
	
	// 过滤器在启动服务器时会自动创建实例，相当于servlet的load-on-startup，这和servlet的实例化时机是不一样的
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
