package top.dongpeili.tool;


public class UUID {

	/**
	 * @summary 带-的uuid
	 * @date 2017年11月25日
	 * @return String
	 * @author dpl
	 */
	public String getUUID() {
		String uuid = java.util.UUID.randomUUID().toString();
		return uuid;
	}
	
}
