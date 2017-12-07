package top.dongpeili.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @summary 国际化测试
 * @date 2017年12月5日
 * @author dpl
 */
@WebServlet("/international")
public class Internationalization extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @summary 获取本地化数据
	 * @date 2017年12月5日
	 * @return void
	 * @author dpl
	 */
	protected void getLocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取客户端的区域设置
		Locale locale = req.getLocale();
		String language = locale.getLanguage();
		String country = locale.getCountry();

		// 设置响应内容类型
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String title = "检测区域设置";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + language + "</h1>\n" + "<h2 align=\"center\">"
				+ country + "</h2>\n" + "</body></html>");
	}

	/**
	 * @summary 语言设置
	 * @date 2017年12月5日
	 * @return void
	 * @author dpl
	 */
	protected void displaySpanish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应内容类型
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// 设置西班牙语言代码
//		resp.setHeader("Content-Language", "es");
		// 设置中文语言代码
		 resp.setHeader("Content-Language", "cn");

		String title = "En Espa&ntilde;ol";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n" + "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" + "<h1>" + "&iexcl;Hola Mundo!"
				+ "</h1>\n" + "</body></html>");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// this.getLocal(req, resp);
		this.displaySpanish(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
