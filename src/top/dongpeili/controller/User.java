package top.dongpeili.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.dongpeili.Base;
import top.dongpeili.tool.Const;
import top.dongpeili.tool.Request;

@WebServlet("/user")
public class User extends Base {

	private static final long serialVersionUID = 1L;
	private static top.dongpeili.service.User user = new top.dongpeili.service.User();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Request request = new Request();
		Map<String, String> map = request.getPara(req);
		String oper = map.get("oper");
		if (oper.equals("insert")) {
			this.insert(map);
		} else if (oper.equals("delete")) {
			this.delete(map);
		} else if (oper.equals("update")) {
			this.update(map);
		} else if (oper.equals("query")) {
			// 设置响应内容类型
			resp.setContentType("text/html;charset=UTF-8");

			// 要重定向的新位置
			String site = new String("http://www.runoob.com");

			resp.setStatus(resp.SC_MOVED_TEMPORARILY);
			resp.setHeader("Location", site);
			// this.query(map, resp);
		}
	}

	@Override
	public String query(Map<String, String> map, HttpServletResponse resp) {
		String r = user.query(map);
		try {
			if (r.equals(Const.no_user)) {
				// resp.sendRedirect("http://localhost:8080/lawyer4/html/index.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(Map<String, String> map) {
		user.insert(map);
		return 0;
	}

	@Override
	public int delete(Map<String, String> map) {
		return super.delete(map);
	}

	@Override
	public int update(Map<String, String> map) {
		return super.update(map);
	}

}
