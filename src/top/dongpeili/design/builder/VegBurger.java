package top.dongpeili.design.builder;

/**
 * @summary 扩展了Burger的实体类 继承抽象类的时候显然都是要重写抽象类的方法的 已经重写完成的方法, 可以不在此重写
 * @date 2017年12月14日
 * @author dpl
 */
public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}

}
