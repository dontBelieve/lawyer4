package top.dongpeili.tool;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @summary request对象操作类
 * @date 2017年11月29日
 * @author dpl
 */
public class Request {

	// 获取web传入的所有数据
	public static Map<String, String> getPara(HttpServletRequest req) throws ServletException, IOException {
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
}
