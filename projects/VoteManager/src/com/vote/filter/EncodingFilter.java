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

public class EncodingFilter implements Filter {
	
	String encoding = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		if( encoding != null){
			response.setContentType("text/html;charset="+encoding);
			response.setCharacterEncoding(encoding);
			request.setCharacterEncoding(encoding);
		}

		// 传递控制到下一个过滤器
		chain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encoding = config.getInitParameter("Encoding");
	}
}
