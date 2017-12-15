package top.dongpeili.design.builder;

/**
 * @summary 第二个实现了食物种类接口的抽象类
 * @date 2017年12月14日
 * @author dpl
 */
public abstract class ColdDrink implements Item{

	/**
	 * 重写食物接口打包的方法
	 */
	@Override
	public Packing packing() {
		return new Bottle();
	}

	/**
	 * 抽象方法, 不重写接口中的方法
	 */
	@Override
	public abstract float price();

}
