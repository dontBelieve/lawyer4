package top.dongpeili.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.dongpeili.Base;
import top.dongpeili.dao.MysqlTest;

@WebServlet("/apartment")
public class Apartment extends Base {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> map = this.getPara(req);
		String oper = map.get("oper");
		if (oper.equals("insert")) {
			this.insert(map);
		} else if (oper.equals("delete")) {
			this.delete(map);
		} else if (oper.equals("update")) {
			this.update(map);
		} else if (oper.equals("query")) {
			this.queryAll(resp);
		}
		super.doPost(req, resp);
	}
	
	/**
	 * @summary 查询, 先测试查询一个的
	 * @date 2017年11月20日
	 * @return String
	 * @author dpl
	 */
	public String queryAll(HttpServletResponse resp) {
//		List<Map<String, String>> list = new Mysql().executeQuery("SELECT * from apartment LIMIT 1, 10");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).get("id"));
//		}
		try {
			// 设置响应内容类型
		    resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.println("收到请求");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "oyo";
	}

	/**
	 * @param map
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insert(Map<String, String> map) throws ServletException, IOException {
		new MysqlTest().testNoPool();
	}

	/**
	 * @summary 其实是在测试连接池
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 * @throws SQLException
	 * @throws NamingException
	 */
	protected void update(Map<String, String> map) throws ServletException, IOException {
		// new Mysql().connectPool();
		new top.dongpeili.dao.PoolTest().testPool();
	}

	/**
	 * @summary 其实是在测试批量处理
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 */
	protected void delete(Map<String, String> map) throws ServletException, IOException {
		new MysqlTest().connect2();
	}
}
