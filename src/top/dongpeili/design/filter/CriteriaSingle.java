package top.dongpeili.design.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

	/**
	 * 筛选出人里面的单身狗
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
				singlePersons.add(person);
			}
		}
		return singlePersons;
	}
}
