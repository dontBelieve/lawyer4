package top.dongpeili.demo.expert;

/**
 * @summary 测试操作线程的一些方法 
 * @date 2017年12月11日
 * @author dpl
 */
public class ThreadClassDemo {
	public static void main(String[] args) {
		Runnable hello = new DisplayMessage("Hello");
		Thread thread1 = new Thread(hello);
		/**
		 * 将该线程标记为守护线程或用户线程。
		 * @question 有啥用啊?
		 * @result 搞成非守护线程, 它就一直在跑. 守护线程跑到一定时候就不跑了
		 */
		thread1.setDaemon(false);
		/**
		 * 改变线程名称，使之与参数 name("hello") 相同。
		 * @result 看不出效果
		 */
		thread1.setName("aaaa");
		System.out.println("Starting hello thread...");
		thread1.start();

		Runnable bye = new DisplayMessage("Goodbye");
		Thread thread2 = new Thread(bye);
		/**
		 * 设置最小的优先级
		 */
		thread2.setPriority(Thread.MIN_PRIORITY);
		/**
		 * 又是守护线程
		 */
		thread2.setDaemon(true);
		System.out.println("Starting goodbye thread...");
		thread2.start();

		System.out.println("Starting thread3...");
		Thread thread3 = new GuessANumber(27);
		thread3.start();
		try {
			/**
			 * 等待该线程终止的时间最长为 millis 毫秒。
			 * @question 这里没有给时间, 应该是等多久?
			 */
			thread3.join();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted.");
		}
		System.out.println("Starting thread4...");
		Thread thread4 = new GuessANumber(75);

		thread4.start();
		System.out.println("main() is ending...");
	}
}

/**
 * @summary 通过实现 Runnable 接口创建线程
 * @date 2017年12月11日
 * @author dpl
 */
class DisplayMessage implements Runnable {
	private String message;

	public DisplayMessage(String message) {
		this.message = message;
	}

	public void run() {
		while (true) {
			System.out.println(message);
		}
	}
}

/**
 * @summary 通过继承 Thread 类创建线程, 猜数字, 1-100
 * @date 2017年12月11日
 * @author dpl
 */
class GuessANumber extends Thread {
	private int number;

	public GuessANumber(int number) {
		this.number = number;
	}

	public void run() {
		int counter = 0;
		int guess = 0;
		do {
			guess = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " guesses " + guess);
			counter++;
		} while (guess != number);
		System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
	}
}