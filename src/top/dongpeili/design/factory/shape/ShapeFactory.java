package top.dongpeili.design.factory.shape;

/**
 * @summary 形状工厂
 * @date 2017年12月7日
 * @author dpl
 */
public class ShapeFactory {

	/**
	 * @summary 获取图形
	 * @date 2017年12月7日
	 * @return Shape
	 * @author dpl
	 */
	public static Shape getShape(Class<? extends Shape> clazz) {
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

		return (Shape) obj;
	}
}
