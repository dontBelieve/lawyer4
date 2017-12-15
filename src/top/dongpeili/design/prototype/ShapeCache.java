package top.dongpeili.design.prototype;

import java.util.Hashtable;

/**
 * @summary 创建一个类, 从数据库获取实体类, 并把他们存储在一个Hashtable中
 * @date 2017年12月15日
 * @author dpl
 */
public class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		Shape shape = null;
		try {
			shape = (Shape) cachedShape.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return shape;
	}

	// 对每种形状都运行数据库查询，并创建该形状
	// shapeMap.put(shapeKey, shape);
	// 例如，我们要添加三种形状
	/**
	 * @summary 数据库查询的话, 每次启动不会会变慢, 并且占内存吗?
	 * @date 2017年12月15日
	 * @return void
	 * @author dpl
	 */
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
