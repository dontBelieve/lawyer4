package top.dongpeili.design.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	/**
	 * 筛选出人里面的女人
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("FEMALE")) {
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}
}
