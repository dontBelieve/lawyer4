package top.dongpeili.design.filter;

/**
 * @summary 一个pojo类, 只有get方法, 没有set方法. 
 * 			三个实例变量: 姓名, 性别, 婚姻状况
 * @date 2017年12月18日
 * @author dpl
 */
public class Person {
	private String name;
	private String gender;
	private String maritalStatus;

	public Person(String name, String gender, String maritalStatus) {
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
}
