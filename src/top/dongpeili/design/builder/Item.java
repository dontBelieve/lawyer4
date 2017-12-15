package top.dongpeili.design.builder;

/*
 * 食物条目和包装的接口
 */
public interface Item {
	public String name();

	/**
	 * @summary 这里返回值是一个接口也可以 
	 * @date 2017年12月14日
	 * @return Packing
	 * @author dpl
	 */
	public Packing packing();

	public float price();
}
