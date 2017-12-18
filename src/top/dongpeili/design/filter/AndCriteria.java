package top.dongpeili.design.filter;

import java.util.List;

/**
 * @summary 这是第一个合二为一的过滤器
 * @date 2017年12月18日
 * @author dpl
 */
public class AndCriteria implements Criteria {

	/**
	 * 实现了标准的对象
	 */
	private Criteria criteria;

	/**
	 * 另一个实现了标准的对象
	 */
	private Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	/**
	 * 使用一个标准过滤入参的人, 返回的人再由其他的标准过滤
	 */
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}
}
