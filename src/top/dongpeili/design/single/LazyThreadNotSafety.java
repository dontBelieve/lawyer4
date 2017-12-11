package top.dongpeili.design.single;

/**
 * @summary 懒汉式线程不安全的单例模式
 * @date 2017年12月10日
 * @author dpl
 */
public class LazyThreadNotSafety {
	private static LazyThreadNotSafety instance;

	private LazyThreadNotSafety() {
	}

	public static LazyThreadNotSafety getInstance() {
		if (instance == null) {
			instance = new LazyThreadNotSafety();
		}
		return instance;
	}

}
