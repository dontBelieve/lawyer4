package top.dongpeili.design.Flyweigh;

/**
 * @summary 这个构造函数有点奇怪, 只有颜色的入参, 其他的原点和半径都要再手动去设置
 * @date 2017年12月21日
 * @author dpl
 */
public class Circle implements Shape {
	private String color;
	private int x;
	private int y;
	private int radius;

	public Circle(String color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
	}
}
