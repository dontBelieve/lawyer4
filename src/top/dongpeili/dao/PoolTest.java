/**
 * 
 */
package top.dongpeili.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @summary 线程池测试
 * @author dpl
 * @date 2017年11月20日
 */
public class PoolTest {
	
	/**
	 * @summary 测试连接池 
	 * @date 2017年11月20日
	 * @return void
	 * @author dpl
	 */
	public void testPool() {
		DataSource ds;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			ds = new Pool().getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "INSERT INTO apartment(id, name) VALUES(UUID(), '巨蟹座";
			for(int i = 0; i < 10000; i++) {
				String sql2 = sql + i + "')";
				stmt.execute(sql2);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		}
	}
	
	/**
	 * @summary
	 * @date 2017年11月17日
	 * @return void
	 * @author dpl
	 * @throws NamingException
	 * @throws SQLException
	 */
	public void connectPool() {

		InitialContext ctx;
		DataSource ds;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * Create a JNDI Initial context to be able to lookup the DataSource
			 *
			 * In production-level code, this should be cached as an instance or static
			 * variable, as it can be quite expensive to create a JNDI context.
			 *
			 * Note: This code only works when you are using servlets or EJBs in a J2EE
			 * application server. If you are using connection pooling in standalone Java
			 * code, you will have to create/configure datasources using whatever mechanisms
			 * your particular connection pooling library provides.
			 */
			ctx = new InitialContext();
			/*
			 * Lookup the DataSource, which will be backed by a pool that the application
			 * server provides. DataSource instances are also a good candidate for caching
			 * as an instance variable, as JNDI lookups can be expensive as well.
			 */
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/marianaJNDI");

			/*
			 * The following code is what would actually be in your Servlet, JSP or EJB
			 * 'service' method...where you need to work with a JDBC connection.
			 */
			conn = ds.getConnection();
			/*
			 * Now, use normal JDBC programming to work with MySQL, making sure to close
			 * each resource when you're finished with it, which permits the connection pool
			 * resources to be recovered as quickly as possible
			 */
			stmt = conn.createStatement();
			String sql = "select * from apartment";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			stmt.close();
			stmt = null;
			conn.close();
			conn = null;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * close any jdbc instances here that weren't explicitly closed during normal
			 * code path, so that we don't 'leak' resources...
			 */
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
				} catch (SQLException sqlex) {
					// ignore, as we can't do anything about it here
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
		}
	}
}
