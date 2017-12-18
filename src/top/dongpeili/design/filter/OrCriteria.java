package top.dongpeili.design.filter;

import java.util.List;

/**
 * @summary 使用或的过滤器
 * @date 2017年12月18日
 * @author dpl
 */
public class OrCriteria implements Criteria {
	/**
	 * 一个标准
	 */
	private Criteria criteria;
	/**
	 * 另一个标准
	 */
	private Criteria otherCriteria;

	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	/**
	 * 分别进行过滤, 再将两个结果集合并
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
		List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

		for (Person person : otherCriteriaItems) {
			if (!firstCriteriaItems.contains(person)) {
				firstCriteriaItems.add(person);
			}
		}
		return firstCriteriaItems;
	}
}
