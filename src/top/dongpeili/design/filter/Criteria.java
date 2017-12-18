package top.dongpeili.design.filter;

import java.util.List;

/**
 * @summary 名为标准的接口
 * @date 2017年12月18日
 * @author dpl
 */
public interface Criteria {

	/**
	 * @summary 遇见标准, 入参为人的列表, 返回人的列表
	 * @date 2017年12月18日
	 * @return List<Person>
	 * @author dpl
	 */
	public List<Person> meetCriteria(List<Person> persons);
}
