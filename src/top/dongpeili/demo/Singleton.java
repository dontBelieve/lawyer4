package top.dongpeili.demo;

/**
 * @question 还没有办法测试
 * @summary 测试volatile
 * @date 2017年12月6日
 * @author dpl
 */
public class Singleton {
	private volatile static Singleton instance = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}
