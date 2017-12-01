package top.dongpeili.service;

import java.util.Map;

import top.dongpeili.dao.Mysql;
import top.dongpeili.interfaces.Service;

/**
 * @summary 公寓控制层 
 * @date 2017年11月28日
 * @author dpl
 */
public class Apartment implements Service {

	@Override
	public int insert(Map<String, String> map) {
		String sql = "INSERT INTO apartment VALUES(UUID(), '立春')";
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
	public String query(Map<String, String> map) {
		return null;
	}

}
