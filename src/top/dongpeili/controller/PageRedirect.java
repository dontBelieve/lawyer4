package top.dongpeili.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @summary 重定向测试, ajax访问的重定向怎么解决?
 * @date 2017年11月30日
 * @author dpl
 */
@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {

	private static final long serialVersionUID = 782597245571996925L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		// 要重定向的新位置
		String site = new String("http://www.runoob.com");

		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
}
