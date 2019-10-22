package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirstServlet implements Servlet {
	
	//该函数用于初始化servlet,就是把该servlet实例装载到内存中
	//该函数只会被调用一次
	public void init(ServletConfig config) throws ServletException{
		System.out.println("初始化完成！");
	}

	//得到ServletConfig对象
	public ServletConfig getServletConfig(){
		return null;
	}
	
	//该函数是服务函数,我们的业务逻辑代码就是写在这里
	//该函数每次都会被调用
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		out.println("hello,world");
	}
	
	//该函数时得到servlet配置信息
	public String getServletInfo(){
		return null;
	}
	
	//销毁该servlet,从内存中清除,该函数被调用一次
	//当 web应用 reload 或者 关闭 tomcat 或者 关机 都会去调用destroy函数
	public void destroy(){
		System.out.println("servlet被销毁！");
	}

}
