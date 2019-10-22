package com.etc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RanCodeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RanCodeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=utf-8");
	
			// 7.禁止浏览器缓存随机图片
			response.setDateHeader("Expires", -1);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			
			// 6.通知客户机以图片方式打开发送过去的数据
			response.setHeader("Content-Type", "image/jpeg");
			
			// 1.在内存中创建一副图片 （在这里修改验证码的背景的长和宽，下面同步）
			BufferedImage image = new BufferedImage(50, 25, BufferedImage.TYPE_INT_RGB);
			
			// 2.向图片上写数据
			Graphics g = image.getGraphics();
			
			// 设背景色
			g.setColor(Color.black);
			g.fillRect(0, 0, 50, 25);
			
			// 3.设置写入数据的颜色和字体
			g.setColor(Color.RED);
			g.setFont(new Font(null, Font.BOLD, 20));
			
			// 4.向图片上写数据
			String num = makeNum();
			
			// 这句话就是把随机生成的数值，保存到session
			request.getSession().setAttribute("checkcode", num); // 通过session就可以直接去到随即生成的验证码了
			g.drawString(num, 0, 20);
			
			// 5.把写好数据的图片输出给浏览器
			ImageIO.write(image, "jpg", response.getOutputStream());
		}
	
		// 该函数时随机生成7位数字
		public String makeNum() {
			Random r = new Random();
			// 9999 可以生成4位（1~9999）
			String num = r.nextInt(9999) + "";
			StringBuffer sb = new StringBuffer();
			// 如果不够4位，前面补零
			for (int i = 0; i < 4 - num.length(); i++) {
				sb.append("0");
			}
			num = sb.toString() + num;
			return num;
		}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
