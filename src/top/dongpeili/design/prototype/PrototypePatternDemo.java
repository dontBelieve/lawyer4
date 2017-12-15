package top.dongpeili.design.prototype;

/**
 * @summary 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆 原型模式没能理解, clone有啥用, 没法测试
 * @date 2017年12月15日
 * @author dpl
 */
public class PrototypePatternDemo {
	public static void main(String[] args) {
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
	}
}
