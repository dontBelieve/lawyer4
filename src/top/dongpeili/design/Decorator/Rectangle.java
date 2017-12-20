package top.dongpeili.design.Decorator;

/**
 * @summary 长方形, 是想形状接口 
 * @date 2017年12月19日
 * @author dpl
 */
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}
