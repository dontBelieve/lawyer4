package top.dongpeili.design.Flyweigh;

import java.util.HashMap;

public class ShapeFactory {
	/**
	 * 这是final是不是就不能变, 不能变永远是一个空的HashMap<>有个屁用? 后面的<>可以不写, 学到了
	 */
	private static final HashMap<String, Shape> circleMap = new HashMap<>();

	/**
	 * @summary final还是能往里面加东西的, 一种颜色只放一种圆
	 * @date 2017年12月21日
	 * @return Shape
	 * @author dpl
	 */
	public static Shape getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);

		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color : " + color);
		}
		return circle;
	}
}
