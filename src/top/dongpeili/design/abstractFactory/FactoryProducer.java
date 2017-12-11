package top.dongpeili.design.abstractFactory;

/**
 * @summary 工厂生产类
 * @date 2017年12月10日
 * @author dpl
 */
public class FactoryProducer {

	/**
	 * @summary 获取抽象工厂
	 * @date 2017年12月10日
	 * @return AbstrctFactory
	 * @author dpl
	 */
	public static AbstrctFactory getFactory(Class<? extends AbstrctFactory> clazz) {
		Object obj = null;
		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (AbstrctFactory) obj;
	}
}
