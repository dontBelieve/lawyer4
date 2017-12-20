package top.dongpeili.design.Composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	/**
	 * 部门
	 */
	private String dept;
	/**
	 * 工资
	 */
	private int salary;
	/**
	 * 员工的列表
	 */
	private List<Employee> subordinates;

	/**
	 * @param name
	 *            拿到参数, 做成一个employee对象, 在放到自己的员工列表里面
	 * @param dept
	 * @param sal
	 */
	// 构造函数
	public Employee(String name, String dept, int sal) {
		this.name = name;
		this.dept = dept;
		this.salary = sal;
		subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public String toString() {
		return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
	}
}
