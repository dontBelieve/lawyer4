package top.dongpeili.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import top.dongpeili.dao.Mysql;
import top.dongpeili.interfaces.Service;
import top.dongpeili.tool.Const;
import top.dongpeili.tool.UUID;

public class User implements Service {

	@Override
	public int insert(Map<String, String> map) {
		String name = map.get("name");
		String id = new UUID().getUUID();
		String password = map.get("password");
		String sql = "INSERT INTO USER VALUES('" + id + "', '" + name + "', '" + password + "')";
		int count = new Mysql().executeUpdate(sql);
		return count;
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
	/**
	 * 单条查询
	 */
	public String query(Map<String, String> map) {
		List<Map<String, String>> list = this.queryList(map);
		if (!list.isEmpty()) {
			return Const.one_user;
		} else {
			// 登录页面跳转
			return Const.no_user;
		}
	}

	/**
	 * @summary 查询用户
	 * @date 2017年11月30日
	 * @return List<Map<String,String>>
	 * @author dpl
	 */
	public List<Map<String, String>> queryList(Map<String, String> map) {
		String name = map.get("name");
		String sql = "SELECT * FROM USER WHERE NAME='" + name + "'";
		List<String> list = new ArrayList<>();
		list.add("name");
		list.add("id");
		List<Map<String, String>> rlist = new Mysql().executeQuery(sql, list);
		return rlist;
	}

}
