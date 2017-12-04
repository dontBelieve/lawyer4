package top.dongpeili.demo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.dongpeili.tool.Request;
import top.dongpeili.tool.UUID;

@WebServlet("/session")
public class SessionTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @summary 获取浏览器session数据, 测试传出数据, 拿回数据. session访问次数, 可存在时间
	 * @date 2017年12月1日
	 * @return void
	 * @author dpl
	 */
	public void playSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Map<String, String> map = Request.getPara(req);
		int visitorCount = 0;
		long startTime = session.getCreationTime();
		long lastTime = session.getLastAccessedTime();
		long stime = lastTime - startTime;
		if (session.isNew()) {
			System.out.println("创建一个新的session");
			session.setAttribute("user", map.get("user") + UUID.getUUID());
		} else {
			System.out.println("访问者: " + session.getAttribute("user"));
			visitorCount = (int) session.getAttribute("visitorCount") + 1;
		}
		session.setAttribute("visitorCount", visitorCount);
		System.out.println("访问次数: " + visitorCount);
		System.out.println("已存在session时间: " + stime);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.playSession(req, resp);
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
