package top.dongpeili.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MysqlTest {

	/**
	 * @summary 测试没有连接池的时候的资源消耗 
	 * @date 2017年11月20日
	 * @return void
	 * @author dpl
	 */
	public void testNoPool() {
		for(int i = 0; i < 1000; i++) {
			this.connect();
		}
	}
	
	
	/**
	 * @summary mysql连接测试 
	 * 			事务测试
	 * 			批量测试
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 */
	public void connect2() {
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;
		try {
			long start = new Date().getTime();
			// new Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mariana", "root", "123456");
			// 只有这句, 是不会提交到数据库的
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			String sql = "INSERT INTO apartment(id, name) VALUES(UUID(), '双子座";
			for(int i = 0; i < 10000; i++) {
				String sql2 = sql + i + "')";
				stat.addBatch(sql2);
			}
//			stat.addBatch("SELECT `name` FROM apartment");
//			rs = stat.executeQuery("SELECT `name` FROM apartment");
//			while (rs.next()) {
//				String name = rs.getString("name");
//				System.out.println(name);
//			}
			// Create an int[] to hold returned values
//			int[] count = stat.executeBatch();
			conn.commit();
			long end = new Date().getTime();
			long ut = end - start;
			System.out.println(ut);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}

			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stat = null;
			}
		}
	}

	/**
	 * @summary mysql连接测试 
	 * 			事务测试
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 */
	public void connect() {
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;
		try {
			long start = new Date().getTime();
			// new Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mariana", "root", "123456");
			// 只有这句, 是不会提交到数据库的
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			
			String sql = "INSERT INTO apartment(id, name) VALUES(UUID(), '双子座";
			for(int i = 0; i < 1; i++) {
				String sql2 = sql + i + "')";
				stat.execute(sql2);
			}
//			rs = stat.executeQuery("SELECT `name` FROM apartment");
//			while (rs.next()) {
//				String name = rs.getString("name");
//				System.out.println(name);
//			}
			conn.commit();
			long end = new Date().getTime();
			long ut = end - start;
			System.out.println(ut);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}

			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stat = null;
			}
		}
	}

	// 测试 通过JDBC检索AUTO_INCREMENT列值
	public void testGenerateKeys() {
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {
			// new Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mariana", "root", "123456");
			//
			// Create a Statement instance that we can use for
			// 'normal' result sets assuming you have a
			// Connection 'conn' to a MySQL database already
			// available
			stmt = conn.createStatement();
			//
			// Issue the DDL queries for the table for this example
			//
			// stmt.executeUpdate("DROP TABLE IF EXISTS autoIncTutorial");
			// stmt.executeUpdate(
			// "CREATE TABLE autoIncTutorial ("
			// + "priKey INT NOT NULL AUTO_INCREMENT, "
			// + "dataField VARCHAR(64), PRIMARY KEY (priKey))");
			//
			// Insert one row that will generate an AUTO INCREMENT
			// key in the 'priKey' field
			//
			stmt.executeUpdate(
					"INSERT INTO autoIncTutorial (dataField) " + "values ('Can I Get the Auto Increment Field?')",
					Statement.RETURN_GENERATED_KEYS);
			//
			// Example of using Statement.getGeneratedKeys()
			// to retrieve the value of an auto-increment
			// value
			//
			int autoIncKeyFromApi = -1;
			rs = stmt.getGeneratedKeys();
			// while (rs.next()) {
			// autoIncKeyFromApi = rs.getInt(1);
			// System.out.println("Key returned from getGeneratedKeys():" +
			// autoIncKeyFromApi);
			// }
			if (rs.next()) {
				// 试过while循环, stmt.getGeneratedKeys()方法返回的rs中, 应该只有刚执行的sql返回的自增键
				autoIncKeyFromApi = rs.getInt(1);
			} else {
				// throw an exception from here
			}
			System.out.println("Key returned from getGeneratedKeys():" + autoIncKeyFromApi);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
	}
}
