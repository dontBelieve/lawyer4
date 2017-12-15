package top.dongpeili.design.prototype;

/**
 * @summary 扩展了Shape
 * @date 2017年12月14日
 * @author dpl
 */
public class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

	/**
	 * 必须和Shape在同一个包里面
	 */
	public Rectangle() {
		super.type = "Rectangle";
	}
}
