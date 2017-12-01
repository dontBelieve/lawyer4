package top.dongpeili;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.dongpeili.interfaces.Controller;

public class Base extends HttpServlet implements Controller {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
		doGet(req, resp);
	}

	// 获取web传入的所有数据
	protected Map<String, String> getPara(HttpServletRequest req) throws ServletException, IOException {
		Enumeration<String> paraNames = req.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		if (null != paraNames) {
			while (paraNames.hasMoreElements()) {
				String para = paraNames.nextElement();
				map.put(para, req.getParameter(para));
			}
		}
		if (null == map.get("oper")) {
			map.put("oper", "");
		}
		return map;
	}

	@Override
	public int insert(Map<String, String> map) {
		return 0;
	}

	@Override
	public int delete(Map<String, String> map) {
		return 0;
	}

	@Override
	public int update(Map<String, String> map) {
		return 0;
	}

	@Override
	public String query(Map<String, String> map, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
