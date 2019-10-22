package com.vote.filter;

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

import com.vote.domain.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// 获取session
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		// 看看请求的资源是什么
		String uri = request.getRequestURI();
		
		// 对于[登录页面]（输入账号）和[登录处理页面]（验证用户，保存用户信息）不能过滤
		if (uri.endsWith("/jspLoad_shoping/") || uri.endsWith("/jspLoad_shoping/GoHallCL")) {
			// 登录页面，直接放行
			chain.doFilter(request, response);
		} else {
			// 检查用户是否登录
			User user = (User) session.getAttribute("user");
			if (user != null) {
				// 用户已登录,放行
				chain.doFilter(request, response);
			} else {
				// 如果没有登录
				response.sendRedirect("/jspLoad_shoping/?err=1");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
