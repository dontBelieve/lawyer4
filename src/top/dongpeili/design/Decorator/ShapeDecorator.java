package top.dongpeili.design.Decorator;

/**
 * @summary 抽象的装饰器类, 其实这里不是抽象类问题也不大吧? 
 * 			实现了形状接口 做成抽象类的话, 继承他的方法要重新写构造函数的
 * @date 2017年12月19日
 * @author dpl
 */
public abstract class ShapeDecorator implements Shape {
	/**
	 * 实现形状接口的对象
	 */
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	/**
	 * 实现形状接口的对象(入参), 调用他的画画方法
	 */
	public void draw() {
		decoratedShape.draw();
	}
}
