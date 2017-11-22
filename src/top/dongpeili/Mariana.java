package top.dongpeili;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mariana")
public class Mariana extends Base{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> paraNames = req.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		if(null != paraNames) {
			while(paraNames.hasMoreElements()) {
				String para = paraNames.nextElement();
				map.put(para, req.getParameter(para));
			}
		}
		
		if(null != map) {
			while(!map.isEmpty()) {
				Iterator<String> it = map.keySet().iterator();
				while(it.hasNext()) {
					String key = it.next();
					System.out.println("key: " + key + ", value: " + map.get(key));
					it.remove();
				}
			}
		}
		super.doGet(req, resp);
	}

	@Override
	// 测试: 关闭浏览器不会进入此方法
	public void destroy() {
		System.out.println("执行destory方法");
		super.destroy();
	}
	
}
