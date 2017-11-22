/**
 * 
 */
package top.dongpeili.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @summary
 * @author dpl
 * @date 2017年11月20日
 */
public class Pool {
	
	private InitialContext initialContext = this.createInitialContext();
	private DataSource dataSource = this.createDataSource("java:comp/env/jdbc/marianaJNDI");
	
	/**
	 * @summary 创建InitialContext对象
	 * @date 2017年11月20日
	 * @return InitialContext
	 * @author dpl
	 */
	private InitialContext createInitialContext(){
		try {
			return new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @summary 获取initialContext对象
	 * @date 2017年11月20日
	 * @return InitialContext
	 * @author dpl
	 */
	public InitialContext getInitialContext() {
		return this.initialContext;
	}
	
	/**
	 * @summary 创建DataSource对象
	 * @date 2017年11月20日
	 * @return InitialContext
	 * @author dpl
	 */
	private DataSource createDataSource(String dataUrl){
		try {
			return (DataSource) this.initialContext.lookup(dataUrl);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @summary 获取initialContext对象
	 * @date 2017年11月20日
	 * @return InitialContext
	 * @author dpl
	 */
	public DataSource getDataSource() {
		return this.dataSource;
	}
}
