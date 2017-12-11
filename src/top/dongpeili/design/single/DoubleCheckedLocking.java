package top.dongpeili.design.single;

/**
 * @summary 双检锁模式
 * 			安全且在多线程情况下能保持高性能。
 * @date 2017年12月11日
 * @author dpl
 */
public class DoubleCheckedLocking {
	/**
	 * 这里volatile很关键, 在多线程中, 强制从共享内存中重新读取该成员变量的值, 保证一致性
	 */
	private volatile static DoubleCheckedLocking singleton;

	private DoubleCheckedLocking() {
	}

	public static DoubleCheckedLocking getSingleton() {
		if (singleton == null) {
			/**
			 * @question 不懂
			 */
			synchronized (DoubleCheckedLocking.class) {
				if (singleton == null) {
					singleton = new DoubleCheckedLocking();
				}
			}
		}
		return singleton;
	}
}
