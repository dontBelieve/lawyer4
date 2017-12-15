package top.dongpeili.design.builder;

/**
 * @summary 实现了Item接口的抽象类, 
 * 			这样可以不用实现接口的方法
 * @date 2017年12月14日
 * @author dpl
 */
public abstract class Burger implements Item {

	/**
	 * 当然抽象类也可以真的重写接口中的方法,
	 * 一会儿要测试一下, 是不是直接就能用
	 */
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	/**
	 * 抽象类重写接口中的方法时, 可以定义方法为抽象, 
	 * 这样就可以了不用实现该方法
	 */
	@Override
	public abstract float price();

}
