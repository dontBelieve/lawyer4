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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.dongpeili.Base;
import top.dongpeili.dao.MysqlTest;
import top.dongpeili.model.PageData;
import top.dongpeili.model.TestPD;

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
			// this.delete(map);
		} else if (oper.equals("update")) {
			this.update(map);
		} else if (oper.equals("query")) {
			// Enumeration<String> headerNames = req.getHeaderNames();
			// while(headerNames.hasMoreElements()) {
			// String paramName = (String)headerNames.nextElement();
			// String paramValue = req.getHeader(paramName);
			// System.out.println(paramName + ": " + paramValue);
			// }
			this.query4(resp);
		}
		super.doPost(req, resp);
	}

	/**
	 * @summary
	 * @date 2017年11月28日
	 * @return void
	 * @author dpl
	 */
	public int update(Map<String, String> map) {
		return 0;
	}

	/**
	 * @summary 查询, 返回json对象
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void query4(HttpServletResponse resp) {
		PrintWriter out = null;
		String json = "{\"success\":true, \"name\":\"雨水\"}";
		try {
			resp.setContentType("application/json; charset=utf-8");
			resp.setCharacterEncoding("UTF-8");
			out = resp.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @summary 查询, 测试改变contentType, 失败
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void query3(HttpServletResponse resp) {
		PrintWriter out = null;
		String json = "{success:true, name:'雨水'}";
		try {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/json");
			out = resp.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @summary 查询, 测试用jsonArray返回json数据
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void query2(HttpServletResponse resp) {
		PrintWriter out = null;
		TestPD tpd = new TestPD();
		try {
			resp.setCharacterEncoding("utf-8");
			JSONArray ja = JSONArray.fromObject(tpd);
			out = resp.getWriter();
			out.print(ja);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @summary 查询, 测试用String返回json数据. 只能返回字符串
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void query(HttpServletResponse resp) {
		PrintWriter out = null;
		String json = "{success:true, name:'雨水'}";
		try {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("json/html");
			out = resp.getWriter();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @summary 新增
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public int insert(Map<String, String> map) {
		return new top.dongpeili.service.Apartment().insert(map);
	}

	/**
	 * @summary 查询, 先测试查询一个的
	 * @date 2017年11月20日
	 * @return String
	 * @author dpl
	 */
	public String testQueryAll(HttpServletResponse resp) {
		// List<Map<String, String>> list = new Mysql().executeQuery("SELECT * from
		// apartment LIMIT 1, 10");
		// for(int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).get("id"));
		// }
		PrintWriter out = null;
		PageData pd = new PageData();
		try {

			// 设置响应内容类型
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			out = resp.getWriter();
			pd.put("name", "雨水");
			JSONObject jo = JSONObject.fromObject("{'name':'雨水'}");
			out.append(jo.toString());
			// pw.println("收到请求");
			// resp.sendError(407, "Need authentication");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return "oyo";
	}

	/**
	 * @summary 测试无线程池
	 * @param map
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void testNoPool(Map<String, String> map) throws ServletException, IOException {
		new MysqlTest().testNoPool();
	}

	/**
	 * @summary 测试连接池
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 * @throws SQLException
	 * @throws NamingException
	 */
	protected void testPool(Map<String, String> map) throws ServletException, IOException {
		// new Mysql().connectPool();
		new top.dongpeili.dao.PoolTest().testPool();
	}

	/**
	 * @summary 测试批量处理
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 */
	protected void testBatch(Map<String, String> map) throws ServletException, IOException {
		new MysqlTest().connect2();
	}
}
