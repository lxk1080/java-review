package com.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Users;

public class FilterServlet extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		// 获取session
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		// 看看请求的资源是什么
		String uri = request.getRequestURI();

		if (uri.startsWith("/servletLoad_UserManager/LoginServlet")
				|| uri.startsWith("/servletLoad_UserManager/RanCodeServlet")
				|| uri.startsWith("/servletLoad_UserManager/LoginCLServlet")) {
			// 登录页面，直接放行
			chain.doFilter(request, response);
		} else {
			// 检查用户是否登录
			Users user = (Users) session.getAttribute("loginUser");
			if (user != null) {
				// 用户已登录,放行
				chain.doFilter(request, response);
			} else {
				// 如果没有登录
				request.setAttribute("err", "请先登录，可以吗？");
				request.getRequestDispatcher("/LoginServlet").forward(request,response);
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
