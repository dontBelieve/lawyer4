package top.dongpeili.design.Decorator;

/**
 * @summary 红色形状装饰器, 继承自装饰器
 * @date 2017年12月19日
 * @author dpl
 */
public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		/**
		 * 无非是, 再加一下自己的逻辑
		 */
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}

}
