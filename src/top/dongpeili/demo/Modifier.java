package top.dongpeili.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @summary 修饰符测试
 * @date 2017年12月6日
 * @author dpl
 */
public class Modifier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String name = "mariana";
	public final int age = 1;

	/**
	 * @question ?????
	 */
	public transient int limit = 55; // 不会持久化

	/**
	 * @summary volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
	 *          而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。 这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
	 */
	// private volatile boolean active = false;

	public static void main(String args[]) {
		Modifier modifier = new Modifier();
		modifier.transientPeople();
	}
	
	/**
	 * @summary 测试volatile
	 * @date 2017年12月6日
	 * @author dpl
	 */
	class Singleton{
	   
	}

	/**
	 * @summary 短暂的人
	 * @explain 当对象被序列化时（写入字节序列到目标文件）时，transient阻止实例中那些用此关键字声明的变量持久化；
	 * 			当对象被反序列化时（从源文件读取字节序列进行重构），这样的实例变量值不会被持久化和恢复。
	 * @date 2017年12月6日
	 * @return void
	 * @author dpl
	 */
	public void transientPeople() {
		People a = new People("李磊", 35);
		System.out.println(a); // 打印对象的值
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream("d://people"));
			os.writeObject(a);// 写入文件(序列化)
			os.close();
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("d://people"));
			a = (People) is.readObject();// 将文件数据转换为对象（反序列化）
			System.out.println(a); // 年龄 数据未定义
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @summary 定义一个需要序列化的类
	 * @date 2017年12月6日
	 * @author dpl
	 */
	class People implements Serializable {
		private static final long serialVersionUID = 1L;
		String name; // 姓名
		transient Integer age; // 年龄

		public People(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String toString() {
			return "姓名 = " + name + " ,年龄 = " + age;
		}

	}

	/**
	 * @question final 对象的引用不能改变，但是里面的值可以改变?
	 * @summary final变量不能被改变
	 * @date 2017年12月6日
	 * @return void
	 * @author dpl
	 */
	public void finalVariate() {
		// name = "yoo";
		// this.age = 2;
	}

	/**
	 * @summary synchronized 关键字声明的方法同一时间只能被一个线程访问
	 * @date 2017年12月6日
	 * @return void
	 * @author dpl
	 */
	public synchronized void showDetails() {

	}

}
