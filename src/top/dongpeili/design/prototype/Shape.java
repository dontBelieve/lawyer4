package top.dongpeili.design.prototype;

/**
 * @summary 创建一个实现了Clonable接口的抽象类
 * @date 2017年12月14日
 * @author dpl
 */
public abstract class Shape implements Cloneable {
	private String id;
	protected String type;

	abstract void draw();

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 重写了clone方法, 不知道有啥子屁用
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

}
