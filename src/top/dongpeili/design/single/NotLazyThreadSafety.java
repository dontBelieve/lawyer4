package top.dongpeili.design.single;

/**
 * @summary 饿汉式线程安全 优点：没有加锁，执行效率会提高。 缺点：类加载时就初始化，浪费内存。
 * @date 2017年12月11日
 * @author dpl
 */
public class NotLazyThreadSafety {
	private static NotLazyThreadSafety instance = new NotLazyThreadSafety();

	private NotLazyThreadSafety() {
	}

	public static NotLazyThreadSafety getInstance() {
		return instance;
	}
}
