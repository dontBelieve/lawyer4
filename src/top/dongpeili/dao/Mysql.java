/**
 * 
 */
package top.dongpeili.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * @summary
 * @author dpl
 * @date 2017年11月20日
 */
public class Mysql {
	
	/**
	 * 用PrepareStatement可防止SQL注入供给, 等我SQL注入攻击成功了再改
	 * 据说比statement要快一些, 测试结果差不多, 或许是测试方法不对
	 */

	/**
	 * @summary 增删改
	 * @date 2017年11月20日
	 * @return int 修改行数
	 * @author dpl
	 */
	@SuppressWarnings("finally")
	public int executeUpdate(String sql) {
		DataSource ds;
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		try {
			ds = new Pool().getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlex) {
					// ignore, as we can't do anything about it here
				}
				conn = null;
			}
			return count;
		}
	}
	
	/**
	 * @summary 批量增删改查
	 * @date 2017年11月25日
	 * @return int
	 * @author dpl
	 */
	public int batchExecuteUpdate(String sql) {
		return 0;
	}
	
	/**
	 * @summary 
	 * @date 2017年11月30日
	 * @return List<Map<String,String>>
	 * @author dpl
	 */
	@SuppressWarnings("finally")
	public List<Map<String, String>> executeQuery(String sql, List<String> l) {
		DataSource ds;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ds = new Pool().getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				for(int j = 0; j < l.size(); j++) {
					String str = l.get(j);
					map.put(str, rs.getString(str));
				}
				list.add(map);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlex) {
					// ignore, as we can't do anything about it here
				}
				conn = null;
			}
			return list;
		}
	}

	/**
	 * @summary 查询
	 * @date 2017年11月20日
	 * @return ResultSet 结果集
	 * @author dpl
	 * @question resultSet的问题很麻烦, 这种类似的方法要写很多. 需要一个简便方法
	 */
	@SuppressWarnings("finally")
	public List<Map<String, String>> executeQuery(String sql) {
		DataSource ds;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ds = new Pool().getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				list.add(map);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlex) {
					// ignore, as we can't do anything about it here
				}
				conn = null;
			}
			return list;
		}
	}

}
