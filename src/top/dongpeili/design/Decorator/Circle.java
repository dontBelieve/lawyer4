package top.dongpeili.design.Decorator;

/**
 * @summary 圆, 实现形状接口
 * @date 2017年12月19日
 * @author dpl
 */
public class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}
