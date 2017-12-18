package top.dongpeili.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @summary 标准接口的实现类, 标准男人
 * @date 2017年12月18日
 * @author dpl
 */
public class CriteriaMale implements Criteria {

	/**
	 * 筛选出人里面的男人
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> malePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("MALE")) {
				malePersons.add(person);
			}
		}
		return malePersons;
	}
}
