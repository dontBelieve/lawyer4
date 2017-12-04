/**
 * 
 */
package top.dongpeili.demo;

/**
 * @summary
 * @author dpl
 * @date 2017年11月21日
 */
public class Static {

	/**
	 * 1. new对象static新 ×; 2. new对象static旧 √
	 */
	private static int sta = 1;

	public int getSta() {
		Static.sta++;
		System.out.println(sta);
		return sta;
	}
}
