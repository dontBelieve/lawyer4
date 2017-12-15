package top.dongpeili.design.builder;

/**
 * @summary 第二个实现了Buger抽象类的实体类 原理是, 同一类的写接口, 这算0级. 有些方法各自实现不同, 抽象类实现, 这是1级
 *          最后实体类, 实现各自方法. 这是2级 这种设计模式其实可以在1级的地方无线扩展
 * @date 2017年12月14日
 * @author dpl
 */
public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 50.5f;
	}

}
