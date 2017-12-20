package top.dongpeili.design.Decorator;

/**
 * @summary 测试装饰器模式
 * @date 2017年12月19日
 * @author dpl
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		/**
		 * 圆形对象
		 */
		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
