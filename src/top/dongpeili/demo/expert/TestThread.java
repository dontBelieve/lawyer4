package top.dongpeili.demo.expert;

/**
 * @summary 测试线程
 * @result 测试得出, 四核的cpu跑四个只做运算的线程就差不多能用完cpu性能了
 * 			风扇吹得呼呼响, 爽
 * @date 2017年12月11日
 * @author dpl
 */
public class TestThread {
	public static void main(String[] args) {
		TestThread thread = new TestThread();
		thread.useRunnable();
		// thread.oneThread();
	}

	/**
	 * @summary 测试实现runnable接口的多线程
	 * @date 2017年12月11日
	 * @return void
	 * @author dpl
	 */
	public void useRunnable() {
		RunnableDemo R1 = new RunnableDemo("RunnableThread-1");
		R1.start();

		// RunnableDemo R2 = new RunnableDemo("RunnableThread-2");
		// R2.start();

		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.start();

		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.start();

		ThreadDemo T3 = new ThreadDemo("Thread-3");
		T3.start();
	}

	/**
	 * @summary 测试单线程占用的cpu
	 * @result 4核的cpu, 内存占用了25%-30%
	 * @date 2017年12月11日
	 * @return void
	 * @author dpl
	 */
	public void oneThread() {
		for (long i = 10000000000L; i > 0; i--) {
			System.out.println("简单递减" + i);
		}
	}
}

/**
 * @summary 实现runnable接口实现多线程
 * @result 使用2个线程丝毫没有提高cpu的使用率; 使用6个线程也没有提高cpu的使用率
 * @date 2017年12月11日
 * @author dpl
 */
class RunnableDemo implements Runnable {

	private Thread t;
	private String threadName;

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		// try {
		for (long i = 10000000000L; i > 0; i--) {
			System.out.println("Thread: " + threadName + ", " + i);
			// // 让线程睡眠一会
			// Thread.sleep(50);
		}
		// } catch (InterruptedException e) {
		// System.out.println("Thread " + threadName + " interrupted.");
		// }
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

/**
 * @summary 继承Thread实现多线程
 * @question 在加上继承了Thread的两个线程, cpu的使用率还是没有提高. 可能是io限制了cpu的使用率
 * @result 果然是io限制了我cpu的发挥
 * @date 2017年12月11日
 * @author dpl
 */
class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;

	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		// try {
		for (long i = 10000000000L; i > 0; i--) {
			long j = i++;

			// System.out.println("Thread: " + threadName + ", " + i);
			// // 让线程睡眠一会
			// Thread.sleep(50);
		}
		// } catch (InterruptedException e) {
		// System.out.println("Thread " + threadName + " interrupted.");
		// }
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}