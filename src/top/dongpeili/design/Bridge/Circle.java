package top.dongpeili.design.Bridge;

import top.dongpeili.design.Bridge.intfc.DrawAPI;

/**
 * @summary 实体类, 圆. 继承自形状抽象类.
 * @date 2017年12月16日
 * @author dpl
 */
public class Circle extends Shape {

	/**
	 * 实例变量, 原点和半径
	 */
	private int x, y, radius;

	/**
	 * 重写构造方法
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * @param drawAPI
	 */
	public Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * 实现抽象方法, draw
	 */
	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}
}
