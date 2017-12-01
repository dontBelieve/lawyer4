package top.dongpeili.interfaces;

import java.util.Map;

/**
 * @summary service 需要实现的接口
 * @date 2017年11月25日
 * @author dpl
 */
public interface Service {

		public int insert(Map<String, String> map);
		
		public int delete(Map<String, String> map);
		
		public int update(Map<String, String> map);
		
		public String query(Map<String, String> map);
		
}
