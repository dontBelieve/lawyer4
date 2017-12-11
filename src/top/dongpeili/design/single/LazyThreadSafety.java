package top.dongpeili.design.single;

/**
 * @summary 懒汉式线程安全 缺点: 效率很低，99% 情况下不需要同步。
 * @date 2017年12月11日
 * @author dpl
 */
public class LazyThreadSafety {
	private static LazyThreadSafety instance;

	private LazyThreadSafety() {
	}

	public static synchronized LazyThreadSafety getInstance() {
		if (instance == null) {
			instance = new LazyThreadSafety();
		}
		return instance;
	}
}
