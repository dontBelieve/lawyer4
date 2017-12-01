package top.dongpeili.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.dongpeili.tool.Request;

/**
 * @summary 测试cookie
 * @date 2017年11月30日
 * @author dpl
 */
@WebServlet("/cookie")
public class TestCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @question WebServlet不能指向类里面的方法很不好用, 有什么办法可以搞定这个问题?
	 */

	/**
	 * @summary 阅读浏览器的cookie
	 * @date 2017年11月30日
	 * @return void
	 * @author dpl
	 */
	public void getCookie(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			// 缺utf-8编码转化
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
		}
	}

	/**
	 * @summary 给浏览器设置cookie
	 * @date 2017年11月30日
	 * @return void
	 * @author dpl
	 */
	public void setCookie(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"), "utf-8"));
		Cookie password = new Cookie("password", URLEncoder.encode(req.getParameter("password"), "utf-8"));
		name.setMaxAge(60 * 60 * 24);
		password.setMaxAge(60 * 60 * 24);
		// 给浏览器两个cookie
		resp.addCookie(name);
		resp.addCookie(password);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> map = Request.getPara(req);
		String oper = map.get("oper");
		if ("set".equals(oper)) {
			this.setCookie(req, resp);
		} else if ("get".equals(oper)) {
			this.getCookie(req, resp);
		}
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
		// super.doPost(req, resp);
	}

}
