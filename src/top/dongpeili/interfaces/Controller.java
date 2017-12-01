package top.dongpeili.interfaces;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public int insert(Map<String, String> map);

	public int delete(Map<String, String> map);

	public int update(Map<String, String> map);

	public String query(Map<String, String> map, HttpServletResponse resp);
}
