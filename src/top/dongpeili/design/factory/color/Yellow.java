package top.dongpeili.design.factory.color;

/**
 * @summary 测试新增一个颜色, 黄色
 * @date 2017年12月10日
 * @author dpl
 */
public class Yellow implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Yellow::fill() method.");
	}

}
