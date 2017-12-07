package top.dongpeili.design.factory;

/**
 * @summary 工厂模式测试
 * @date 2017年12月7日
 * @author dpl
 */
public class FactoryPatternDemo {
	public static void main(String[] args) {
		Circle circle = (Circle) ShapeFactory.getShape(Circle.class);
		circle.draw();
		Rectangle rectangle = (Rectangle) ShapeFactory.getShape(Rectangle.class);
		rectangle.draw();
	}
}
