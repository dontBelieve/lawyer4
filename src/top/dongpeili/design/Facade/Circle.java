package top.dongpeili.design.Facade;

/**
 * @summary 实现接口的实体类
 * @date 2017年12月20日
 * @author dpl
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}
