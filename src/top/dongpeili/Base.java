package top.dongpeili;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Base extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	// 获取web传入的所有数据
	protected Map<String, String> getPara(HttpServletRequest req) throws ServletException, IOException {
		Enumeration<String> paraNames = req.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		if(null != paraNames) {
			while(paraNames.hasMoreElements()) {
				String para = paraNames.nextElement();
				map.put(para, req.getParameter(para));
			}
		}
		if(null == map.get("oper")) {
			map.put("oper", "");
		}
		return map;
	}
}
