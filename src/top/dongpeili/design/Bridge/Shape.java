package top.dongpeili.design.Bridge;

import top.dongpeili.design.Bridge.intfc.DrawAPI;

/**
 * @summary 形状抽象类 
 * @date 2017年12月16日
 * @author dpl
 */
public abstract class Shape {
	/**
	 * 画图接口对象, 里面就一个画圈的方法
	 */
	protected DrawAPI drawAPI;

	/**
	 * 形状构造方法 , 给类里面的对象赋值
	 * @param drawAPI 画图接口对象
	 */
	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	/**
	 * @summary 定义抽象类中的抽象方法 , 画图方法
	 * @date 2017年12月16日
	 * @return void
	 * @author dpl
	 */
	public abstract void draw();
}
